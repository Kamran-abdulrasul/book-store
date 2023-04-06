package com.example.bookstore.controller;

import com.example.bookstore.dto.BookCriteria;
import com.example.bookstore.dto.BookResponse;
import com.example.bookstore.dto.SaveBookDto;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@PathVariable Long id, @RequestBody SaveBookDto dto) {

        bookService.saveBook(id, dto);

    }

    @GetMapping
    public List<BookResponse> getBooks(BookCriteria bookCriteria) {
        return bookService.getBooks(bookCriteria);

    }


}