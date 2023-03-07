package com.example.adotedog.config.security;


import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class EmailPasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public EmailPasswordAuthenticationToken(String email, String password) {
        super(email, password);
    }
}
