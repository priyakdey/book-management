package com.example.goodreads.api.controller;

import com.example.goodreads.api.model.response.BookCatalogResponseModel;
import com.example.goodreads.common.model.BookDTO;
import com.example.goodreads.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/search/books")
public class CatalogController {
    private ICatalogService catalogService;

    @Autowired
    public CatalogController(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("{title}")
    public ResponseEntity<BookCatalogResponseModel> getBooksLikeTitle(@PathVariable String title) {
        List<BookDTO> booksLikeTitle = catalogService.getBooksLikeTitle(title);
        BookCatalogResponseModel responseModel = new BookCatalogResponseModel();
        responseModel = responseModel.mapDTOResponseModel(booksLikeTitle);

        return new ResponseEntity<>(responseModel, HttpStatus.FOUND);
    }
}
