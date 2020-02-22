package com.example.goodreads.api.model.response;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthorResponseModel implements Serializable {

    private static final long serialVersionUID = -2182685986244598979L;

    private String fullName;

    @JsonBackReference
    private List<BookResponseModel> books = new ArrayList<>();

    public AuthorResponseModel() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<BookResponseModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponseModel> books) {
        this.books = books;
    }
}
