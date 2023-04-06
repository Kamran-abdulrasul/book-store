package com.example.bookstore.dto;

import com.example.bookstore.entity.UserEntity;
import lombok.*;

import java.time.LocalDate;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private String name;
    private String author;
    private String genre;
    private UserEntity user;
    private LocalDate publisherDate;
}
