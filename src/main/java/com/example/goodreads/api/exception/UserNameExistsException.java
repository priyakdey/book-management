package com.example.goodreads.api.exception;

public class UserNameExistsException extends RuntimeException {

    private static final long serialVersionUID = 153529586531254363L;

    public UserNameExistsException(String userNameExists) {
        super(userNameExists);
    }
}
