package com.example.prueba.model;

import lombok.Data;

/**
 * Clase que representa una solicitud para crear un producto.
 */
@Data
public class CrearProductoRequest {
    private Producto producto;
    private String usuario;
}
