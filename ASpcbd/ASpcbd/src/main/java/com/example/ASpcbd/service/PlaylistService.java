package com.example.ASpcbd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ASpcbd.model.Playlist;
import com.example.ASpcbd.model.Usuario;

@Service
public class PlaylistService {
    private static List<Playlist> Playlists = new ArrayList<>();

    public List<Playlist> getAllItems() {
        return PlaylistService.Playlists;
    }

    public Playlist getItem(int id) {
        return findPlaylist(id);
    }

    public Playlist createPlaylist(Playlist item) {
        PlaylistService.Playlists.add(item);
        return item;
    }

    public Playlist updatePlaylist(int id, Playlist newPlaylist) {
        Playlist playlistASerAtualizada = findPlaylist(id);

        if (playlistASerAtualizada == null)
            return null;

        
        Playlists.remove(playlistASerAtualizada);

        playlistASerAtualizada.setNome(newPlaylist.getNome());
        playlistASerAtualizada.setCriador(newPlaylist.getCriador());

        Playlists.add(playlistASerAtualizada);
        
        return playlistASerAtualizada;
    }

    public void deletePlaylist(int id) {
        Playlist playlistASerExcluida = findPlaylist(id);

        if (playlistASerExcluida == null)
            return;

        Playlists.remove(playlistASerExcluida);
    }

    public Playlist findPlaylist(int id) {
        Playlist response = null;

        for (Playlist playlist : Playlists) {
            if (playlist.getId() == id) {
                response = playlist;
                break;
            }
        }
        return response;
    }


}
