package com.example.reactappbackend.utils.exception;

import com.example.reactappbackend.utils.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAllExceptions(Exception exception) {
        return ErrorResponse.of(exception);
    }
}
