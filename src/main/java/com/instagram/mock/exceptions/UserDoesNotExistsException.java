package com.instagram.mock.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserDoesNotExistsException extends RuntimeException{

    private final HttpStatus code = HttpStatus.NOT_FOUND;

    public UserDoesNotExistsException(String message) {
        super(message);
    }
}
