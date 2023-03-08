package com.example.adotedog.controller;

import com.example.adotedog.dto.JwtDto;
import com.example.adotedog.dto.LoginDto;
import com.example.adotedog.model.Usuario;
import com.example.adotedog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("create-jwt")
    public JwtDto createJwt(@RequestBody LoginDto loginDto) {
        return service.createJwt(loginDto);
    }

    @PostMapping("create-user")
    public void createUser(@RequestBody Usuario usuario) {
        service.createUser(usuario);
    }

    @PostMapping("validated-jwt")
    public boolean validatedJwt(@RequestParam String token) {
        return service.validatedJwt(token);
    }
}
