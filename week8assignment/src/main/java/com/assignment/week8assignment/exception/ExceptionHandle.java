package com.assignment.week8assignment.exception;

import org.springframework.http.HttpStatusCode;

public class ExceptionHandle extends RuntimeException {
    HttpStatusCode statusCode;
    public ExceptionHandle(HttpStatusCode statusCode,String message) {
        super(message);

        this.statusCode = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
