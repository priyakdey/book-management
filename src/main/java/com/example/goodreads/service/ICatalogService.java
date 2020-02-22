package com.example.goodreads.service;

import com.example.goodreads.common.model.BookDTO;

import java.util.List;

public interface ICatalogService {

    List<BookDTO> getBooksLikeTitle(String title);
}
