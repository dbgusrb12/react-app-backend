package com.example.reactappbackend.model.user.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserResponse {
    private String token;
    private String refreshToken;
    private String userId;
    private int auth;
}
