package com.example.bookstore.controller;

import com.example.bookstore.dto.ApiError;
import com.example.bookstore.enums.AppMessage;
import com.example.bookstore.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ApiError handle(Exception ex) {
        log.error("Exception: ", ex);
        return new ApiError(AppMessage.UNEXPECTED_EXCEPTION.getCode(), AppMessage.UNEXPECTED_EXCEPTION.getMessage());
    }


    @ExceptionHandler
    @ResponseStatus(NOT_FOUND)
    public ApiError handle(NotFoundException ex) {
        return new ApiError(ex.getCode(), ex.getMessage());

    }


    @ExceptionHandler
    @ResponseStatus(FORBIDDEN)
    public ApiError handle(AccessDeniedException ex){

        return new ApiError("ACCESS_DENIED","User dont have access for this operation");

    }
}
