package com.example.goodreads.service.impl;

import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.data.dao.IBookDAO;
import com.example.goodreads.data.entity.Book;
import com.example.goodreads.service.ICatalogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CatalogServiceImpl implements ICatalogService {
    private IBookDAO bookDAO;

    @Autowired
    public CatalogServiceImpl(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<BookDTO> getBooksLikeTitle(String title) {
        List<Book> books = bookDAO.getBooksLikeTitle(title);
        List<BookDTO> bookDTOList = new ArrayList<>();

        books.stream()
                .forEach(book -> {
                    BookDTO bookDTO = new BookDTO();
                    BeanUtils.copyProperties(book, bookDTO);
                    bookDTOList.add(bookDTO);
                });

        return bookDTOList;
    }
}
