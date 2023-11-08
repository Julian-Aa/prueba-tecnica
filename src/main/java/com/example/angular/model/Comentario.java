package com.example.angular.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Comentario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Comentario (){}
}
