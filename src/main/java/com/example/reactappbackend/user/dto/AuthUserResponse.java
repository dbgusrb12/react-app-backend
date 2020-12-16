package com.example.reactappbackend.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUserResponse {
    private int id;
    private boolean isAdmin;
    private boolean isAuth;
    private String email;
    private String name;
    private String lastName;
    private String role;
    private String image;
}
