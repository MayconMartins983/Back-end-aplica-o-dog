package com.example.adotedog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "isAdotado" })
public class DogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String raca;
    private Integer idadeEmMeses;
    private String cor;
    private String descricao;
    private boolean vacinado;
    private Integer quantidadeDonos;
    private boolean isAdotado;
    private String telefone;
    private String nomeDono;
    private String codigo;
    @Lob
    private byte[] foto;
}
