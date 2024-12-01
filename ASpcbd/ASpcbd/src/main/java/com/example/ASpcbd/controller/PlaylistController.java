package com.example.ASpcbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.core.annotation.Put;
import com.example.ASpcbd.model.Playlist;
import com.example.ASpcbd.service.PlaylistService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    @GetMapping
    public ResponseEntity<List<Playlist>> getPlaylist() {
        return new ResponseEntity(service.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") int id) {
        Playlist response = service.getItem(id);

        if (response == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Playlist> savePlaylist(@Valid @RequestBody Playlist playlist) throws Exception {
        Playlist response = service.createPlaylist(playlist);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable("id") int id, @Valid @RequestBody Playlist novosDados) {

        Playlist playlistASerAtualizada = service.getItem(id);

        if (playlistASerAtualizada == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Playlist response = service.updatePlaylist(id, playlistASerAtualizada);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable("id") int id) {

        if (service.getItem(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        service.deletePlaylist(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
