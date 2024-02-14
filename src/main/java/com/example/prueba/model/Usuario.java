package com.example.prueba.model;

import com.example.prueba.config.Auditable;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un usuario en el sistema.
 */
@Data
@Entity
@Table(name = "usuarios")
public class Usuario extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
}
