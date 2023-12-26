package com.example.crud_api.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data

public class Response {
    private String statusMessage;
    private HttpStatus httpStatus;
    private Object object;

    public Response(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Response(String statusMessage, HttpStatus httpStatus) {
        this.statusMessage = statusMessage;
        //this(statusMessage)
        this.httpStatus = httpStatus;
    }

    public Response(String statusMessage, HttpStatus httpStatus, Object object) {
        this(statusMessage, httpStatus);
        this.object = object;
    }
}
