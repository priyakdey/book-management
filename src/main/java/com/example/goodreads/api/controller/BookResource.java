package com.example.goodreads.api.controller;

import com.example.goodreads.api.model.request.NewBookRequestModel;
import com.example.goodreads.api.model.response.AuthorResponseModel;
import com.example.goodreads.api.model.response.BookResponseModel;
import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<Void> addBook(@RequestBody NewBookRequestModel requestModel) {
        // TODO: To add validation for the book request model
        // Validate request
//        boolean isValidRequest = new BookModelValidator().validateNewBook(requestModel);
//        if (!isValidRequest) {
//            throw new InvalidRequestException(AppConstants.INVALID_BOOK_REQUEST_MESSAGE);
//        }

        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(requestModel, bookDTO);
        this.bookService.addBook(bookDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{title}")
    public ResponseEntity<BookResponseModel> getBookByTitle(@PathVariable String title) {
        BookDTO bookDTO = bookService.getBookByTitle(title);
        BookResponseModel responseModel = new BookResponseModel();
        BeanUtils.copyProperties(bookDTO, responseModel);

        List<AuthorResponseModel> authorResponseModelList = new ArrayList<>();

        bookDTO.getAuthors().forEach(author -> {
            AuthorResponseModel authorResponseModel = new AuthorResponseModel();
            authorResponseModel.setFullName(author.getFullName());
            authorResponseModelList.add(authorResponseModel);
        });

        responseModel.setAuthorResponseModels(authorResponseModelList);

        return new ResponseEntity<>(responseModel, HttpStatus.FOUND);
    }
}
