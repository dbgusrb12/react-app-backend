package com.example.reactappbackend.utils.exception;

import com.example.reactappbackend.utils.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAllExceptions(HttpServletRequest request, Exception exception) {
        return ErrorResponse.of(request, exception);
    }
}
