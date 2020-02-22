package com.example.goodreads.service;

import com.example.goodreads.common.model.BookDTO;

public interface IBookService {

    void addBook(BookDTO bookDTO);

    BookDTO getBookByTitle(String title);
}
