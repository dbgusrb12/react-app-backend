package com.example.reactappbackend.utils.exception;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Error {
    public static CustomException of(ErrorCode error) {
        return new CustomException(
                error.name(),
                error.getCode(),
                error.getMessage()
        );
    }
    public static CustomException of(ErrorCode error, String message) {
        return new CustomException(
                error.name(),
                error.getCode(),
                error.getMessage() + " : " + message
        );
    }

    @Getter
    public static class CustomException extends RuntimeException {
        private String name;
        private int statusCode;

        private CustomException(String name, int statusCode, String message) {
            super(message);
            this.name = name;
            this.statusCode = statusCode;
        }
    }
}
