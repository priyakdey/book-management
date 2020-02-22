package com.example.goodreads.common.utils;

import com.example.goodreads.api.model.request.NewBookRequestModel;

import java.util.regex.Pattern;

public class BookModelValidator {

    public boolean validateNewBook(NewBookRequestModel model) {
        boolean hasValidISBN = Pattern.matches("[^0-9]", model.getIsbn());
        boolean isAuthorsValid = model.getAuthors().size() != 0 ? true : false;

        return hasValidISBN && isAuthorsValid ? true : false;
    }
}
