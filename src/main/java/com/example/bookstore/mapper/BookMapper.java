package com.example.bookstore.mapper;

import com.example.bookstore.dto.BookResponse;
import com.example.bookstore.dto.SaveBookDto;
import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.entity.UserEntity;


import java.time.LocalDate;

public class BookMapper {

    public static BookEntity saveDtoToEntity(UserEntity user, SaveBookDto dto) {
        return BookEntity.builder()
                .name(dto.getName().toUpperCase())
                .author(dto.getAuthor().toUpperCase())
                .genre(dto.getGenre().toUpperCase())
                .language(dto.getLanguage().toUpperCase())
                .publisherDate(LocalDate.now())
                .user(user)
                .build();
    }

    public static BookResponse mapEntityToDto(BookEntity entity) {
        return BookResponse.builder()
                .name(entity.getName())
                .author(entity.getAuthor())
                .genre(entity.getGenre())
                .publisher_name(entity.getUser().getName())
                .publisher_surname(entity.getUser().getSurname())
                .publisherDate(entity.getPublisherDate())
        .build();
    }
}

