package com.example.prueba.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un producto vendido en el sistema.
 */
@Data
@Entity
@Table(name = "productos_vendidos")
public class ProductoVendido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;

    private int cantidad;
}
