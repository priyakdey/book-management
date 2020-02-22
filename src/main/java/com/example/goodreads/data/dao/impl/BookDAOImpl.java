package com.example.goodreads.data.dao.impl;

import com.example.goodreads.api.exception.BookNotFoundException;
import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.common.utils.AppConstants;
import com.example.goodreads.data.dao.IBookDAO;
import com.example.goodreads.data.entity.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class BookDAOImpl extends GenericDAOImpl<Book> implements IBookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        super(entityManager, Book.class);
    }


    @Override
    public void addBook(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        book.addBookToAuthors();

        super.persist(book);
    }

    @Override
    public BookDTO getBookByTitle(String title) {
        TypedQuery<Book> query = entityManager.createNamedQuery("query.Book.findBookByTitle", Book.class);
        query.setParameter("title", title);
        try{
            Book book = query.getSingleResult();
            BookDTO bookDTO = new BookDTO();
            BeanUtils.copyProperties(book, bookDTO);
            return bookDTO;
        } catch (NoResultException ex) {
            throw new BookNotFoundException(AppConstants.BOOK_NOT_FOUND_EXCEPTION);
        }
    }


    @Override
    public List<Book> getBooksLikeTitle(String title) {
        String queryString = "select b from Book b" + " " +
                             "INNER JOIN FETCH b.authors a" + " " +
                             "where b.title like :title";
        TypedQuery<Book> query = entityManager.createQuery(queryString, Book.class);
        query.setParameter("title", title + "%");
        query.setLockMode(LockModeType.PESSIMISTIC_READ);
        return query.getResultList();
    }
}
