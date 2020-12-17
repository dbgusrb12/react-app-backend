package com.example.reactappbackend.model.user.request;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String email;
    private String password;
}
