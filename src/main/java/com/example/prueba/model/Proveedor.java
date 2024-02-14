package com.example.prueba.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un proveedor en el sistema.
 */
@Data
@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
}
