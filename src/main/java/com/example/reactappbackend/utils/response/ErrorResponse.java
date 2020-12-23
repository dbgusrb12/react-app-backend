package com.example.reactappbackend.utils.response;

import com.example.reactappbackend.utils.exception.Error.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorResponse extends Response {
    private String error;
    private String message;

    private ErrorResponse() {
        super(null);
        this.setStatus(Status.FAIL);
        this.setStatusCode(HttpStatus.BAD_REQUEST.value());
    }

    public ErrorResponse statusCode(int statusCode) {
        setStatusCode(statusCode);
        return this;
    }

    public ErrorResponse error(String error) {
        setError(error);
        return this;
    }

    public ErrorResponse message(String message) {
        setMessage(message);
        return this;
    }

    public static ErrorResponse of(Exception exception) {
        return new ErrorResponse()
                .statusCode((exception instanceof CustomException) ? ((CustomException) exception).getStatusCode() : 5000)
                .error((exception instanceof CustomException) ? ((CustomException) exception).getName() : exception.getClass().getSimpleName())
                .message(exception.getMessage());
    }
}
