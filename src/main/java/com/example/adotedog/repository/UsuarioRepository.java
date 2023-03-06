package com.example.adotedog.repository;

import com.example.adotedog.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findUsuarioByEmail(String email);
}
