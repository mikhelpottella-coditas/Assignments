package com.assignment.week8assignment.exception;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ErrorResponce {


    HttpStatusCode code;
    String message;
    LocalDateTime dateTime;

    public ErrorResponce(HttpStatusCode code, String message, LocalDateTime dateTime) {
        this.code = code;
        this.message = message;
        this.dateTime = dateTime;
    }
}
