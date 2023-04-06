package com.example.bookstore.mapper;


import com.example.bookstore.dto.UserDto;
import com.example.bookstore.entity.UserEntity;

public class UserMapper {

    public static UserEntity saveDtoToEntity(UserDto dto) {
        return UserEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .authority(dto.getAuthorityName())
                .build();
    }
}
