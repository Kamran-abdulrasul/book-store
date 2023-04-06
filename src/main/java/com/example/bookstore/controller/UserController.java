package com.example.bookstore.controller;

import com.example.bookstore.dto.UserDto;
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
    void savePublisher(@RequestBody UserDto dto) {
        userService.savePublisher(dto);

    }

    @GetMapping
    @RequestMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {

      return   userService.getUserById(id);
    }
}
