package com.example.ASpcbd.model;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Campo email é obrigatório")
    private String email;

    @NotBlank(message = "Campo data de nascimento é obrigatório.")
    private String dataDeNascimento;

    private List<Playlist> Playlists;
}
