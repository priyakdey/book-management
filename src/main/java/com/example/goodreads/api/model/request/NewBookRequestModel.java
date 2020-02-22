package com.example.goodreads.api.model.request;

import com.example.goodreads.common.utils.AppConstants;
import com.example.goodreads.data.entity.Author;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class NewBookRequestModel implements Serializable {

    private static final long serialVersionUID = -4864502540472142011L;

    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    @NotNull(message = AppConstants.VALID_AUTHOR_MESSAGE)
    private List<Author> authors;

    public NewBookRequestModel() {
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
