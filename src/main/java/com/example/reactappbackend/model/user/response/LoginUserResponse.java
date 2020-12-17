package com.example.reactappbackend.model.user.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserResponse {
    private boolean loginSuccess;
    private String userId;
}
