package com.example.reactappbackend.controller;

import com.example.reactappbackend.model.user.request.LoginUserRequest;
import com.example.reactappbackend.model.user.request.RegisterRequest;
import com.example.reactappbackend.model.user.response.AuthUserResponse;
import com.example.reactappbackend.model.user.response.LoginUserResponse;
import com.example.reactappbackend.model.user.response.RegisterResponse;
import com.example.reactappbackend.service.UserService;
import com.example.reactappbackend.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/register")
    public Response<RegisterResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        // name, email, password 를 받아서 유효성 검사, 비밀번호 암호화 처리 후 DB에 넣고 success 처리
        RegisterResponse registerUserResponse = userService.registerUser(registerRequest);
        return new Response<>(registerUserResponse);
    }

    @PostMapping(value = "/login")
    public Response<LoginUserResponse> loginUser(@RequestBody LoginUserRequest loginUser) {
        // email, password 를 이용해 디비에서 유저 확인 후 토큰 발급과 success 처리
        LoginUserResponse loginUserResponse = userService.loginUser(loginUser);
        return new Response<>(loginUserResponse);
    }

    @GetMapping(value = "/auth")
    public Response<AuthUserResponse> authCheck(@RequestHeader("token") String token) {
        // 토큰 체크해서 인증 하는 로직 구현
        int auth = 0;
        if(StringUtils.hasText(token)) {
            auth = userService.authCheck(token);
        }
        return new Response<>(
            AuthUserResponse.builder()
                    .auth(auth)
                    .build()
        );
    }
}
