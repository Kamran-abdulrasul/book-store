package com.example.bookstore.service;

import com.example.bookstore.config.JwtTokenUtil;
//import com.example.bookstore.dto.AuthRequest;
import com.example.bookstore.dto.AuthToken;
import com.example.bookstore.enums.AppMessage;
import com.example.bookstore.exception.AppException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService  {

  //  private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;


 //   public AuthToken authenticate(AuthRequest authRequest) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
//        } catch (Exception e) {
//            log.info("{}", e);
//            throw new AppException(AppMessage.USERNAME_OR_PASSWORD_INCORRECT);
//        }
//
//        String token = jwtTokenUtil.generateToken(authRequest.getEmail());
//
//        return AuthToken
//                .builder()
//                .token(token)
//                .username(authRequest.getEmail())
//                .build();
    }




//}
