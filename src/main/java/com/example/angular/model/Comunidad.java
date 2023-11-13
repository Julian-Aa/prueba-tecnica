package com.example.angular.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "comunidad")
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagenUrl;
    private Long usuarioId;

    @JsonManagedReference
    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    public Comunidad (){}
}
