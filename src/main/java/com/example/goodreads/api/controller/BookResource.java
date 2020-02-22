package com.example.goodreads.api.controller;

import com.example.goodreads.api.exception.InvalidRequestException;
import com.example.goodreads.api.model.request.NewBookRequestModel;
import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.common.utils.AppConstants;
import com.example.goodreads.common.utils.BookModelValidator;
import com.example.goodreads.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/books",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
public class BookResource {
    private IBookService bookService;

    @Autowired
    public BookResource(IBookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public void addBook(@RequestBody NewBookRequestModel requestModel) {
        // TODO: To add validation for the book request model
        // Validate request
//        boolean isValidRequest = new BookModelValidator().validateNewBook(requestModel);
//        if (!isValidRequest) {
//            throw new InvalidRequestException(AppConstants.INVALID_BOOK_REQUEST_MESSAGE);
//        }

        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(requestModel, bookDTO);
        this.bookService.addBook(bookDTO);
    }
}
