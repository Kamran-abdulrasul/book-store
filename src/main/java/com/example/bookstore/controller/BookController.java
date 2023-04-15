package com.example.bookstore.controller;

import com.example.bookstore.dto.*;
import com.example.bookstore.enums.AppMessage;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto saveBook(@PathVariable Long id, @RequestBody SaveBookDto dto) throws AccessDeniedException {

        bookService.saveBook(id, dto);

        return new ResponseDto(AppMessage.BOOK_CREATED.getCode(), AppMessage.BOOK_CREATED.getMessage());

    }

    @GetMapping
    public List<BookResponse> getBooks(BookCriteria bookCriteria) {

        return bookService.getBooks(bookCriteria);

    }

    @GetMapping("publisher/{userId}")
    public BookResponseByUser getBooksByUser(@PathVariable Long userId) {
        return bookService.getBooksByPublisher(userId);
    }

    @PatchMapping("book-list/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto listBookForUser(@PathVariable Long id, @RequestBody ResponseListBook listBook) throws AccessDeniedException {

        bookService.listBookForUser(id, listBook);

        return new ResponseDto(AppMessage.BOOK_ADDED.getCode(), AppMessage.BOOK_ADDED.getMessage());
    }


}