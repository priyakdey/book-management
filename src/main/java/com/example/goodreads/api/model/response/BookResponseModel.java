package com.example.goodreads.api.model.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookResponseModel implements Serializable {
    private static final long serialVersionUID = -1682723580803289077L;

    private String isbn;
    private String title;

    @JsonManagedReference
    private List<AuthorResponseModel> authorResponseModels = new ArrayList<>();

    public BookResponseModel() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorResponseModel> getAuthorResponseModels() {
        return authorResponseModels;
    }

    public void setAuthorResponseModels(List<AuthorResponseModel> authorResponseModels) {
        this.authorResponseModels = authorResponseModels;
    }
}
