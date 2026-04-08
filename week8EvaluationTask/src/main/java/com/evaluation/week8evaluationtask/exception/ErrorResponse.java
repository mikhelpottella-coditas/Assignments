package com.evaluation.week8evaluationtask.exception;

import lombok.Data;
import org.springframework.http.HttpStatusCode;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {


    HttpStatusCode code;
    String message;
    LocalDateTime dateTime;

    public ErrorResponse(HttpStatusCode code, String message, LocalDateTime dateTime) {
        this.code = code;
        this.message = message;
        this.dateTime = dateTime;
    }
}