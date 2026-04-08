package com.assignment.week8assignment.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ValidateErrorResponse {

    Integer statusCode;
    Map<String,String> errors;
    LocalDateTime timestamp;

    ValidateErrorResponse(Integer statusCode, Map<String,String> errors , LocalDateTime timestamp) {
        this.statusCode = statusCode;
        this.errors = errors;
        this.timestamp = timestamp;
    }

}
