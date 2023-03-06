package com.example.adotedog.service;

import com.example.adotedog.config.security.jwt.JwtProvider;
import com.example.adotedog.dto.JwtDto;
import com.example.adotedog.dto.LoginDto;
import com.example.adotedog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    public JwtDto createJwt(LoginDto loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.gerarJwt(authentication);

        return new JwtDto(jwt);
    }
}
