package com.example.prueba.respository;

import com.example.prueba.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de repositorio para la entidad Producto.
 * Proporciona métodos para acceder y manipular datos relacionados con los productos.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
