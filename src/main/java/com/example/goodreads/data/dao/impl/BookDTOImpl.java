package com.example.goodreads.data.dao.impl;

import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.data.dao.IBookDAO;
import com.example.goodreads.data.entity.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookDTOImpl extends GenericDAOImpl<Book> implements IBookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public BookDTOImpl(EntityManager entityManager) {
        super(entityManager, Book.class);
    }


    @Override
    public void addBook(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        book.addBookToAuthors();

        super.persist(book);
    }
}
