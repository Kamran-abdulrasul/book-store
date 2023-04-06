package com.example.bookstore.dto;

import com.example.bookstore.entity.UserEntity;
import lombok.Data;

@Data
public class SaveBookDto {
    private String name;
    private String author;
    private String genre;
    private String language;



}
