package com.example.adotedog.model;

import com.example.adotedog.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    private String cpf;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "role")
    private List<RoleModel> roles;
}
