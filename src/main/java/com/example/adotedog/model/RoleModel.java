package com.example.adotedog.model;

import com.example.adotedog.enums.RoleUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RoleModel  implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleUser role;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.role.toString();
    }
}
