package com.example.adotedog.config.security;

import com.example.adotedog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements  UserDetailsService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var usuario = repository.findUsuarioByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado."));

        return UserDetailsImp.build(usuario);
    }
}
