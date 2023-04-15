package com.example.bookstore.controller;

import com.example.bookstore.dto.ResponseDto;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.enums.AppMessage;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto saveUser(@RequestBody UserDto dto) {
        userService.saveUser(dto);

        return new ResponseDto(AppMessage.USER_CREATED.getCode(), AppMessage.USER_CREATED.getMessage());

    }

    @GetMapping
    @RequestMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }
}
