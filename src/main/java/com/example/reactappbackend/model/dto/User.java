package com.example.reactappbackend.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private String userId;
    private Integer auth;
    private String userName;
    private String email;
    private String password;
    private String token;
    private Date createDate;
    private Date updateDate;
}
