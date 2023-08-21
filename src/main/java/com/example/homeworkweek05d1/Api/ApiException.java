package com.example.homeworkweek05d1.Api;

public class ApiException extends RuntimeException {
    private String message;

    public ApiException(String message) {
        super(message);
    }
}
