package com.example.reactappbackend.utils.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@ToString
public class Response<T> {
    private Status status;
    private int statusCode;
    private T data;

    private Response() {
        this(null);
    }

    public Response(T t) {
        this.status = Status.OK;
        this.statusCode = HttpStatus.OK.value();
        this.data = t;
    }

    public Response data(T data) {
        setData(data);
        return this;
    }

    public static Response ok () {
        return new Response();
    }

}
