package com.example.reactappbackend.utils.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    InvalidEmail(1000, "Invalid email"),
    InvalidPassword(1001, "Invalid password"),
    ExistingEmail(1002, "email already exist"),
    JdbcError(1003, "jdbc error");



    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
