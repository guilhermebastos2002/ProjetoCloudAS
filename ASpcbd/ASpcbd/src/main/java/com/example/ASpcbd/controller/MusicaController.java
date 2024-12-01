package com.example.ASpcbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ASpcbd.model.Musica;
import com.example.ASpcbd.service.MusicaService;

@RestController
@RequestMapping("/musica")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public ResponseEntity<List<Musica>> getMusica() {
        return new ResponseEntity(service.getAllItems(), HttpsStatus.OK);
    }
}
