package com.example.ASpcbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ASpcbd.model.Musica;
import com.example.ASpcbd.service.MusicaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/musica")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public ResponseEntity<List<Musica>> getMusica() {
        return new ResponseEntity(service.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Musica> getMusicaById(@PathVariable("id") int id) {
        Musica response = service.getItem(id);


    if (response == null)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Musica> saveMusica(@Valid @RequestBody Musica musica) throws Exception {
        Musica response = service.createMusica(musica);

        return new ResponseEntity<>(response, HttpStatus.CREATED); 
    }

    @PutMapping("{id}")
    public ResponseEntity<Musica> updateMusica(@PathVariable("id") int id, @Valid @RequestBody Musica novosDados) {
        
        Musica musicaASerAtualizada = service.getItem(id);

        if (musicaASerAtualizada == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Musica response = service.updateMusica(id, musicaASerAtualizada);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Musica> deleteMusica(@PathVariable("id") int id) {

        if (service.getItem(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        service.deleteMusica(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
