package com.example.prueba.model;

import com.example.prueba.config.Auditable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa una venta en el sistema.
 */
@Data
@Entity
@Table(name = "ventas")
public class Venta extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<ProductoVendido> productosVendidos;

    private double montoTotal;
}
