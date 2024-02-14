package com.example.prueba.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un producto en el sistema.
 */
@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String modelo;
    private int cantidadEnBodega;
    private double valorVenta;
}
