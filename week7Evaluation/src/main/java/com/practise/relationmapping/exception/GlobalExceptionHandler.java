package com.practise.relationmapping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponce> handleCustomException(CustomException customException){
        ErrorResponce errorResponce = new ErrorResponce(customException.getStatus().value(),customException.getMessage());
        return new ResponseEntity<>(errorResponce, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponce> handleRunException(RuntimeException e ){
        ErrorResponce errorResponce = new ErrorResponce(HttpStatus.INTERNAL_SERVER_ERROR.value(),"something went wrong");
        return new ResponseEntity<>(errorResponce, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
