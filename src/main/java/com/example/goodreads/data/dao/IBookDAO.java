package com.example.goodreads.data.dao;

import com.example.goodreads.common.model.BookDTO;

public interface IBookDAO {

    void addBook(BookDTO bookDTO);

    BookDTO getBookByTitle(String title);
}
