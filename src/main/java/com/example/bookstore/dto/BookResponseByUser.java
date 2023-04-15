package com.example.bookstore.dto;

import com.example.bookstore.entity.BookEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookResponseByUser {

    private String publisherName;
    private String publisherSurname;
    private List<BookEntity> books;

}
