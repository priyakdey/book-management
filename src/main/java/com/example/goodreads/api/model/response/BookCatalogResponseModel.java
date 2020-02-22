package com.example.goodreads.api.model.response;

import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.data.entity.Author;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookCatalogResponseModel implements Serializable {

    private static final long serialVersionUID = 6025256701086669020L;

    private List<BookCatalogResponse> responseModelList = new ArrayList<>();

    private class BookCatalogResponse {
        private String isbn;
        private String title;
        private List<String> author;

        BookCatalogResponse() {}

        BookCatalogResponse(String isbn, String title, List<String> author) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
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

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }
    }

    public BookCatalogResponseModel() {
    }


    public List<BookCatalogResponse> getResponseModelList() {
        return responseModelList;
    }

    public void setResponseModelList(List<BookCatalogResponse> responseModelList) {
        this.responseModelList = responseModelList;
    }



    public BookCatalogResponseModel mapDTOResponseModel(List<BookDTO> bookDTOList) {
        List<BookCatalogResponse> list = new ArrayList<>();
        bookDTOList.forEach(bookDTO -> {
            List<String> authorFullNameList = mapAuthorName(bookDTO.getAuthors());
            BookCatalogResponse model =
                    new BookCatalogResponse(bookDTO.getIsbn(), bookDTO.getTitle(), authorFullNameList);
            list.add(model);
        });
        this.responseModelList = list;
        return this;
    }

    private List<String> mapAuthorName(List<Author> authorsList) {
        return authorsList.stream()
                        .map(author -> author.getFullName())
                        .collect(Collectors.toList());
    }
}
