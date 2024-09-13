package com.instagram.mock.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InstagramErrorResponse {
    private String message;
    private LocalDateTime timeStamp;
    private int statusCode;
}
