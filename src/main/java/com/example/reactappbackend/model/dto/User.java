package com.example.reactappbackend.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {
    private String userId;
    private int auth;
    private String userName;
    private String email;
    private String password;
    private String token;
    private Date createDate;
    private Date updateDate;
}
