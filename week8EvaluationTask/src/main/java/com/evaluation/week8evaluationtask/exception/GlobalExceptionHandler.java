package com.evaluation.week8evaluationtask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidateErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error-> errors.put(error.getField(),error.getDefaultMessage())
        );


        ValidateErrorResponse errorResponse = new ValidateErrorResponse(400,errors, LocalDateTime.now());
        return new ResponseEntity<ValidateErrorResponse>(errorResponse, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handelMethodMismatch(MethodArgumentTypeMismatchException e) {
        ErrorResponse errorResponce = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE,e.getMessage(),LocalDateTime.now());

        return new ResponseEntity<>(errorResponce,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleException(CustomException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(),e.getMessage(),LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,e.getStatusCode());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleException(RuntimeException e) {
        ErrorResponse errorResponce = new ErrorResponse(HttpStatusCode.valueOf(500),e.getMessage(),LocalDateTime.now());

        return new ResponseEntity<>(errorResponce,HttpStatusCode.valueOf(500));
    }

}