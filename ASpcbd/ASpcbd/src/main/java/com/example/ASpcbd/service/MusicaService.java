package com.example.ASpcbd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ASpcbd.model.Musica;

@Service
public class MusicaService {
    private static List<Musica> Musicas = new ArrayList<>();

    public List<Musica> getAllItems() {
        return MusicaService.Musicas;
    }

    public Musica getItem(int id) {
        return findMusica(id);
    }

    public Musica createMusica(Musica item) {
        MusicaService.Musicas.add(item);
        return item;
    }

    public Musica updateMusica(int id, Musica newMusica) {
        Musica musicaASerAtualizada = findMusica(id);

        if (musicaASerAtualizada == null)
            return null;


        Musicas.remove(musicaASerAtualizada);
    
        musicaASerAtualizada.setNome(newMusica.getNome());
        musicaASerAtualizada.setArtista(newMusica.getArtista());
        
        Musicas.add(musicaASerAtualizada);

        return musicaASerAtualizada;

    }

    public void deleteMusica(int id) {
        Musica musicaASerExcluida = findMusica(id);

        if (musicaASerExcluida == null)
            return;

        //Remove da lista
        Musicas.remove(musicaASerExcluida);
    }

    public Musica findMusica(int id) {
        Musica response = null;

        for (Musica musica : Musicas) {
            if (musica.getId() == id) {
                response = musica;
                break;
            }
        }
        return response;
    }
    
}