package com.example.bookstore.service;

import com.example.bookstore.dto.UserDto;
import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.mapper.UserMapper;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.example.bookstore.enums.AppMessage.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    public final UserRepository userRepository;
    @Qualifier("encoder")
    private final PasswordEncoder passwordEncoder;


    public void saveUser(UserDto dto) {

        var user = UserMapper.saveDtoToEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
    }

    public UserDto getUserById(Long id) {

        var user = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(
                        String.format(USER_NOT_FOUND.getCode()),
                        (USER_NOT_FOUND.getMessage())));

        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserEntitiesByEmail(username);
        if (Objects.nonNull(user)) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getAuthority().name()));
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("Username as email " + username + " not found");
        }
    }
}
