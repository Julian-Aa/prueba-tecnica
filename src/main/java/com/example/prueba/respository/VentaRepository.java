package com.example.prueba.respository;

import com.example.prueba.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Interfaz de repositorio para la entidad Venta.
 * Proporciona métodos para acceder y manipular datos relacionados con las ventas.
 */
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    /**
     * Busca ventas por fecha.
     *
     * @param fecha La fecha de las ventas a buscar.
     * @return Una lista de ventas que ocurrieron en la fecha especificada.
     */
    List<Venta> findByFecha(Date fecha);
}
