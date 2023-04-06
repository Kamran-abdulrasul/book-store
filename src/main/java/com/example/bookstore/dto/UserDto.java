package com.example.bookstore.dto;

import com.example.bookstore.enums.AuthorityName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    public String name;
    public String surname;
    public String password;
    public String email;
    public AuthorityName authorityName;

}
