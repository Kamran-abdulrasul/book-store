package com.example.bookstore.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private int code;
    private String message;

    public ResponseDto(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
