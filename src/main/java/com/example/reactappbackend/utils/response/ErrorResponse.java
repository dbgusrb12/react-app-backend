package com.example.reactappbackend.utils.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorResponse extends Response {
    private String error;
    private String message;

    private ErrorResponse() {
        super();
        this.status(Response.Status.FAIL)
                .setStatusCode(HttpStatus.BAD_REQUEST.value());
    }

    public ErrorResponse error(String error) {
        setError(error);
        return this;
    }

    public ErrorResponse message(String message) {
        setMessage(message);
        return this;
    }

    public static ErrorResponse of(HttpServletRequest request, Exception exception) {
        return new ErrorResponse()
                .error(exception.getClass().getSimpleName())
                .message(exception.getMessage());
    }
}
