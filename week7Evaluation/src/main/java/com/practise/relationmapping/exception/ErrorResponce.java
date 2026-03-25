package com.practise.relationmapping.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorResponce {

    LocalDateTime localDateTime;
    int status;
    String error;

    public ErrorResponce(int status, String error) {
        this.localDateTime = LocalDateTime.now();
        this.status = status;
        this.error = error;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
