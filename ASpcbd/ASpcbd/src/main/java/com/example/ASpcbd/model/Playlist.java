package com.example.ASpcbd.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Playlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Campo criador é obrigatório.")
    private String criador;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "musica_id")
    private List<Musica> musicas = new ArrayList<>();

}