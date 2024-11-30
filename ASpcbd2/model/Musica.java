package com.example.ASpcbd.model;

import jakarta.persistence.GeneratedValue;
import lombok.Data;

@Data
public class Musica {
    
    @GeneratedValue
    private int id;

    @NotBlank(message = "")
}
