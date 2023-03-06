package com.example.adotedog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum RoleUser {

    ADMIN("Admim"),
    USER("User");

    @Getter
    private String descricao;
}
