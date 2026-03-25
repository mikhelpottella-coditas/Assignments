package com.assignment.week8assignment.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    Integer statusCode;
    String message;
    LocalDateTime timestamp;

    ErrorResponse(Integer statusCode, String message, LocalDateTime timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

}
