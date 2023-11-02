package com.example.angular.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Articulo {
    @Id
    private long id;
    private String titulo;
    private String contenido;
    private String autor;
    private String imagen;
    public Articulo() {
    }
}
