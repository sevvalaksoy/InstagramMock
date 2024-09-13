package com.instagram.mock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<InstagramErrorResponse> handleException(EmailPhoneExistException emailPhoneExistException){
        InstagramErrorResponse errorResponse = new InstagramErrorResponse(emailPhoneExistException.getMessage(),
                LocalDateTime.now(), emailPhoneExistException.getCode().value());
        return new ResponseEntity<>(errorResponse, emailPhoneExistException.getCode());
    }
    @ExceptionHandler
    public ResponseEntity<InstagramErrorResponse> handleException(UserDoesNotExistsException userDoesNotExistsException){
        InstagramErrorResponse errorResponse = new InstagramErrorResponse(userDoesNotExistsException.getMessage(),
                LocalDateTime.now(), userDoesNotExistsException.getCode().value());
        return new ResponseEntity<>(errorResponse, userDoesNotExistsException.getCode());
    }
    @ExceptionHandler
    public ResponseEntity<InstagramErrorResponse> handleException(Exception exception){
        InstagramErrorResponse errorResponse = new InstagramErrorResponse(exception.getMessage(),
                LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
