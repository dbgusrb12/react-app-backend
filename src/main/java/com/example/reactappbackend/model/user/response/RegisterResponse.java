package com.example.reactappbackend.model.user.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private String token;
    private String refreshToken;
}
