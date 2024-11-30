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

    public Musica createMusica(Musica item) throws Exception {

        String owner = item.getName();
        int numMusica = 0;
        for (Musica musica : Musicas) {
            if (musica.getName() == nome) {
                numMusica++;
            }
        }

        MusicaService.Musicas.add(item);
        return item;
    }

    public Musica updateMusica(int id, Musica newMusica) {
        Musica musicaASerAtualizada = findMusica(id);

        if (musicaASerAtualizada == null)
            return null;


        Musica.remove(musicaASerAtualizada);
    
        musicaASerAtualizada.setName(newMusica.getName());
        musicaASerAtualizada.setOwner(newMusica.getOwner());
        musicaASerAtualizada.setStatus(newMusica.getStatus());
        musicaASerAtualizada.setDescription(newMusica.getDescription());
        
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