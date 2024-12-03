package com.example.ASpcbd.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "playlist_id")
    private List<Playlist> playlists = new ArrayList<>();

}