package com.example.adotedog.config.security;

import com.example.adotedog.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsImp implements UserDetails {

    private Long userId;
    private String nomeCompleto;
    @JsonIgnore
    private String senha;
    private String email;
    private Collection<? extends GrantedAuthority> roles;

    public static UserDetailsImp build(Usuario usuario) {
        var roles = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
        return new UserDetailsImp(usuario.getId(), usuario.getNomeCompleto(),
                usuario.getSenha(), usuario.getEmail(), roles);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
