package com.example.reactappbackend.model.user.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUserResponse {
    private boolean admin;
    private boolean auth;
}
