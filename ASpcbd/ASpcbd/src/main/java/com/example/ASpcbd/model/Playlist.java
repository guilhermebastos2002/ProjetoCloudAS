package com.example.ASpcbd.model;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Playlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Campo criador é obrigatório.")
    private String criador;

    private List<Musica> Musicas;
}
