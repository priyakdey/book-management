package com.example.goodreads.api.exception;

public class UserNameDoesNotExistsException extends RuntimeException {

    private static final long serialVersionUID = 8532823596613168173L;

    public UserNameDoesNotExistsException(String message) {
        super(message);
    }
}
