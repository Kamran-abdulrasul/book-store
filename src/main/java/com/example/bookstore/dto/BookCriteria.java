package com.example.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCriteria {

    private String name;
    private String author;
    private String genre;
    private String language;
    private String publisher;

}
