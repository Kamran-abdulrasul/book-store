package com.example.bookstore.service;

import com.example.bookstore.dto.UserDto;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.mapper.UserMapper;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.bookstore.enums.AppMessage.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    @Qualifier("encoder")
    private final PasswordEncoder passwordEncoder;





    public void savePublisher(UserDto dto) {

        var user = UserMapper.saveDtoToEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
    }

    public UserDto  getUserById(Long id){

        var user=userRepository.findById(id).orElseThrow(() ->
        new NotFoundException(
                String.format(String.valueOf(USER_NOT_FOUND))));


        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }

}
