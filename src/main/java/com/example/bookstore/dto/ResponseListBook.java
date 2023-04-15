package com.example.bookstore.dto;

import com.example.bookstore.entity.BookEntity;
import lombok.Data;

import java.util.List;

@Data
public class ResponseListBook {

    private List<Long> bookIds;


}
