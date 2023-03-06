package com.example.adotedog.controller;

import com.example.adotedog.dto.JwtDto;
import com.example.adotedog.dto.LoginDto;
import com.example.adotedog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UsuarioService service;

    @PostMapping("create-jwt")
    public JwtDto createJwt(LoginDto loginDto) {
        return service.createJwt(loginDto);
    }
}
