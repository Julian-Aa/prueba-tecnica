package com.example.prueba.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Clase que representa un registro de auditoría en el sistema.
 */
@Data
@Entity
@Table(name = "registros_auditoria")
public class RegistroAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accion;
    private String usuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
}
