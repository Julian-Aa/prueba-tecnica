package com.example.prueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Clase que representa una actividad de registro en el sistema.
 */
@Data
@Entity
public class ActividadRegistro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoAccion;
    private LocalDateTime fechaHora;
    private String usuario;
}
