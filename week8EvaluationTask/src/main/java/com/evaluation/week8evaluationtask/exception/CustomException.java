package com.evaluation.week8evaluationtask.exception;

import org.springframework.http.HttpStatusCode;

public class CustomException extends RuntimeException {
    HttpStatusCode statusCode;
    public CustomException(HttpStatusCode statusCode,String message) {
        super(message);

        this.statusCode = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}