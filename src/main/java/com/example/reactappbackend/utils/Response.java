package com.example.reactappbackend.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class Response {
    private Status status;
    private int statusCode;

    public Response() {
        status = Status.OK;
        statusCode = HttpStatus.OK.value();
    }

    public Response status(Status status) {
        setStatus(status);
        return this;
    }

    public Response statusCode(int statusCode) {
        setStatusCode(statusCode);
        return this;
    }

    public static Response of () {
        return new Response();
    }

    public enum Status {
        OK,
        FAIL
    }
}
