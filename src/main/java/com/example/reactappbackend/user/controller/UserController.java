package com.example.reactappbackend.user.controller;

import com.example.reactappbackend.user.dto.*;
import com.example.reactappbackend.utils.CommonResponse;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private Gson gson = new Gson();

    @GetMapping(value = "/auth")
    public AuthUserResponse authCheck() {
        return AuthUserResponse.builder()
                .id(1)
                .isAdmin(true)
                .isAuth(false)
                .email("dbgusrb12@gmail.com")
                .name("현규")
                .lastName("유")
                .role("관리자")
                .image("")
                .build();
    }

    @GetMapping(value = "/logout")
    public LogoutUserResponse logoutUser() {
        LogoutUserResponse logoutUserResponse = new LogoutUserResponse();
        logoutUserResponse.setSuccess(true);
        return logoutUserResponse;
    }

    @PostMapping(value = "/login")
    public LoginUserResponse loginUser(@RequestBody LoginUserRequest loginUser) {
        System.out.println(loginUser.getEmail() + " : " + loginUser.getPassword());
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        loginUserResponse.setLoginSuccess(true);
        loginUserResponse.setUserId("sampleUserId");
        return loginUserResponse;
    }

    @PostMapping(value = "/register")
    public RegisterUserResponse registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        System.out.println(registerUserRequest.toString());
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setSuccess(true);
        return registerUserResponse;
    }
}
