package com.example.goodreads.data.dao;

import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.data.entity.Book;

import java.util.List;

public interface IBookDAO {

    void addBook(BookDTO bookDTO);

    BookDTO getBookByTitle(String title);

    List<Book> getBooksLikeTitle(String title);
}
