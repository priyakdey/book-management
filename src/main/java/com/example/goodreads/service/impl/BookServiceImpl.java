package com.example.goodreads.service.impl;

import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.data.dao.IBookDAO;
import com.example.goodreads.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
    private IBookDAO bookDAO;

    @Autowired
    public BookServiceImpl(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        this.bookDAO.addBook(bookDTO);
    }
}
