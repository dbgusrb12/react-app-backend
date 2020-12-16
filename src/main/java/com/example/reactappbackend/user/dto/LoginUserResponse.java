package com.example.reactappbackend.user.dto;

import lombok.Data;

@Data
public class LoginUserResponse {
    private boolean loginSuccess;
    private String userId;
}
