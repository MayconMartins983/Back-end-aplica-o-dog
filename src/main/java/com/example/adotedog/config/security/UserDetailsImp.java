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
import java.util.List;
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
        var role = new SimpleGrantedAuthority(usuario.getRole().getAuthority());
        return new UserDetailsImp(usuario.getId(), usuario.getNomeCompleto(),
                usuario.getSenha(), usuario.getEmail(), List.of(role));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
