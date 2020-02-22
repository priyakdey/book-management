package com.example.goodreads.api.exception;

public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 3917775101872816433L;

    public InvalidRequestException(String message) {
        super(message);
    }
}
