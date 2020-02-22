package com.example.goodreads.common.utils;

public interface AppConstants {
    /**
     * Validation Messages
     */
    String VALID_USER_NAME_MESSAGE = "User Name should be between 5 and 10 characters";
    String VALID_NAME_MESSAGE = "Please enter a valid name";
    String VALID_AUTHOR_MESSAGE = "List of Authors cannot be empty";

    /**
     * Exception Messages
     */
    String USER_NAME_EXISTS = "This username is already registered";
    String USER_NAME_NOT_EXISTS = "User Name does not exists";
    String INVALID_BOOK_REQUEST_MESSAGE = "Invalid Request";
    String BOOK_NOT_FOUND_EXCEPTION = "Book does not exists";
}

