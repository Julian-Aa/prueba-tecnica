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

    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    @JsonBackReference
    private Comunidad comunidad;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String tipo;

    public Comentario (){}
}
