package com.example.goodreads.common.model;

import com.example.goodreads.data.entity.Author;

import java.util.List;

public class BookDTO {
    private String isbn;
    private String title;
    private List<Author> authors;

    public BookDTO() {
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
