package com.example.reactappbackend.controller;

import com.example.reactappbackend.model.user.request.LoginUserRequest;
import com.example.reactappbackend.model.user.request.RegisterUserRequest;
import com.example.reactappbackend.model.user.response.AuthUserResponse;
import com.example.reactappbackend.model.user.response.LoginUserResponse;
import com.example.reactappbackend.model.user.response.LogoutUserResponse;
import com.example.reactappbackend.model.user.response.RegisterUserResponse;
import com.example.reactappbackend.service.UserService;
import com.example.reactappbackend.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/auth")
    public Response<AuthUserResponse> authCheck() {
        // 토큰 체크해서 인증 하는 로직 구현

        return new Response<>(
            AuthUserResponse.builder()
                    .id(1)
                    .isAdmin(true)
                    .isAuth(false)
                    .email("dbgusrb12@gmail.com")
                    .name("현규")
                    .lastName("유")
                    .role("관리자")
                    .image("")
                    .build()
        );
    }

    @GetMapping(value = "/logout")
    public Response<LogoutUserResponse> logoutUser() {
        // 토큰 파기 후 success 처리

        return new Response<>(LogoutUserResponse.builder().success(true).build());
    }

    @PostMapping(value = "/login")
    public Response<LoginUserResponse> loginUser(@RequestBody LoginUserRequest loginUser) {
        // email, password 를 이용해 디비에서 유저 확인 후 토큰 발급과 success 처리

        return new Response<>(
                LoginUserResponse
                        .builder()
                        .loginSuccess(true)
                        .userId("sampleUserId")
                        .build()
        );
    }

    @PostMapping(value = "/register")
    public Response<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        // name, email, password 를 받아서 유효성 검사, 비밀번호 암호화 처리 후 DB에 넣고 success 처리

        return new Response<>(
            RegisterUserResponse
                    .builder()
                    .success(true)
                    .build()
        );
    }
}
