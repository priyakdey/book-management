package com.example.goodreads.api.exception;

public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 514016647787355096L;

    public BookNotFoundException(String message) {
        super(message);
    }
}
