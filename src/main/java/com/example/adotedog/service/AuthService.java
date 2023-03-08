package com.example.adotedog.service;

import com.example.adotedog.config.security.EmailPasswordAuthenticationToken;
import com.example.adotedog.config.security.jwt.JwtProvider;
import com.example.adotedog.dto.JwtDto;
import com.example.adotedog.dto.LoginDto;
import com.example.adotedog.enums.RoleUser;
import com.example.adotedog.model.Usuario;
import com.example.adotedog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtDto createJwt(LoginDto loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new EmailPasswordAuthenticationToken(loginDto.getEmail(), loginDto.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.gerarJwt(authentication);

        return new JwtDto(jwt);
    }

    public void createUser(Usuario user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw  new RuntimeException(("Já existe um user com este email cadastrado."));
        }

        var roleUser = roleService.findByRoleName(RoleUser.USER);
        user.setRole(roleUser);
        user.setSenha(passwordEncoder.encode(user.getSenha()));

        repository.save(user);
    }

    public boolean validatedJwt(String token) {
        return jwtProvider.validateJwt(token);
    }
}
