package com.example.bookstore.enums;

public enum AppMessage {

    UNEXPECTED_EXCEPTION("500","UNEXPECTED EXCEPTION MESSAGE"),
    BOOK_CREATED("201", "Book is created successful"),
    USER_CREATED("202", "User is created successful"),
    BOOK_ADDED("203","Book is added to list"),
    ALREADY_HAVE("401", "Email already exists"),
    USER_NOT_FOUND("405", "User not found"),
    BOOK_NOT_FOUND("405","Book not found"),
    USERNAME_OR_PASSWORD_INCORRECT("404", "Username or password is incorrect"),
    FAILED_SEND_EMAIL("406", "Failed to send an email");

    private String code;
    private String message;

    AppMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

