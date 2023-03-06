package com.example.adotedog.config.security;

import com.example.adotedog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        var usuario = repository.findUsuarioByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado."));

        return UserDetailsImp.build(usuario);
    }
}
