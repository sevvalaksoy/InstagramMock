package com.instagram.mock.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmailPhoneExistException extends RuntimeException{
    private HttpStatus code;

    public EmailPhoneExistException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }
}
