package com.example.bookstore.mapper;

import com.example.bookstore.dto.BookResponse;
import com.example.bookstore.dto.SaveBookDto;
import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.entity.UserEntity;


import java.time.LocalDate;

public class BookMapper {

    public static BookEntity saveDtoToEntity(UserEntity user, SaveBookDto dto) {
        return BookEntity.builder()
                .name(dto.getName())
                .author(dto.getAuthor())
                .genre(dto.getGenre())
                .language(dto.getLanguage())
                .publisherDate(LocalDate.now())
                .build();
    }

    public static BookResponse mapEntityToDto(BookEntity entity) {
        return BookResponse.builder()
                .name(entity.getName())
                .author(entity.getAuthor())
                .genre(entity.getGenre())
                .user(entity.getUser())
                .publisherDate(entity.getPublisherDate())
        .build();
    }
}

