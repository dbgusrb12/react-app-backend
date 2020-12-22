package com.example.reactappbackend.service;

import com.example.reactappbackend.mapper.UserMapper;
import com.example.reactappbackend.model.dto.User;
import com.example.reactappbackend.model.user.request.LoginUserRequest;
import com.example.reactappbackend.model.user.request.RegisterRequest;
import com.example.reactappbackend.model.user.response.LoginUserResponse;
import com.example.reactappbackend.model.user.response.RegisterResponse;
import com.example.reactappbackend.utils.JwtUtils;
import com.example.reactappbackend.utils.TokenStatus;
import com.example.reactappbackend.utils.exception.Error;
import com.example.reactappbackend.utils.exception.ErrorCode;
import com.example.reactappbackend.utils.exception.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.MessageDigest;
import java.util.UUID;

import static com.example.reactappbackend.utils.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        if(!ObjectUtils.isEmpty(userMapper.findByEmail(registerRequest.getEmail()))) {
            throw Error.of(ExistingEmail);
        }
        String uuid = generateUUid();
        String password = encryptPassword(registerRequest.getPassword());
        String token = JwtUtils.createToken(registerRequest.getEmail(), registerRequest.getName());
        String refreshToken = JwtUtils.createRefreshToken();

        User user = User.builder()
                .userId(uuid)
                .auth(0)
                .userName(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(password)
                .token(refreshToken)
                .build();
        try {
            userMapper.registerUser(user);
        } catch(Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
        return RegisterResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .build();
    }


    public LoginUserResponse loginUser(LoginUserRequest loginUser) {
        User user = userMapper.findByEmail(loginUser.getEmail());
        // email 이 존재하지 않으면 에러 리턴
        if(ObjectUtils.isEmpty(user)) {
            throw Error.of(InvalidEmail);
        }

        // password 가 일치하지 않으면 에러 리턴
        String password = encryptPassword(loginUser.getPassword());
        if(!user.getPassword().equals(password)) {
            throw Error.of(InvalidPassword);
        }

        // 로그인 확인 되었으면 access token, refresh token 생성
        String token = JwtUtils.createToken(user.getEmail(), user.getUserName());
        user.setToken(JwtUtils.createRefreshToken());

        // DB에 refresh token 업데이트 후 token, refresh token, userId를 리턴
        try {
            userMapper.updateToken(user);
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }

        return LoginUserResponse.builder()
                .userId(user.getUserId())
                .refreshToken(user.getToken())
                .token(token)
                .admin(user.getAuth() != 0)
                .auth(true)
                .build();
    }

    public boolean authCheck(String token) {
        String email = JwtUtils.claimsParsingFromToken(token, "email");
        User user = userMapper.findByEmail(email);
        if(user.getAuth() == 0) {
            return false;
        }
        return true;
    }

    private String generateUUid() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (byte hashByte : hash) {
                String hex = Integer.toHexString(0xff & hashByte);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
