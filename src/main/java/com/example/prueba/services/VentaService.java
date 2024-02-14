package com.example.prueba.services;

import com.example.prueba.model.Venta;
import com.example.prueba.respository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Servicio para la gestión de ventas.
 */
@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    /**
     * Obtiene las ventas del día especificado.
     *
     * @param fecha La fecha del día para el cual se obtienen las ventas.
     * @return Una lista de ventas que ocurrieron en el día especificado.
     */
    public List<Venta> obtenerVentasDelDia(Date fecha) {
        return ventaRepository.findByFecha(fecha);
    }

    /**
     * Calcula el monto total de las ventas proporcionadas.
     *
     * @param ventas La lista de ventas de las cuales se calculará el monto total.
     * @return El monto total de las ventas.
     */
    public double calcularMontoTotalVentas(List<Venta> ventas) {
        double montoTotal = 0.0;
        for (Venta venta : ventas) {
            montoTotal += venta.getMontoTotal();
        }
        return montoTotal;
    }
}
