package com.example.prueba.Controller;

import com.example.prueba.model.ProductoVendido;
import com.example.prueba.model.Venta;
import com.example.prueba.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

/**
 * Controlador para generar informes relacionados con ventas.
 */
@RestController
@RequestMapping("/informes")
public class InformeController {

    @Autowired
    private VentaService ventaService;

    /**
     * Genera un informe final del día que muestra las ventas realizadas y sus detalles.
     *
     * @return String que contiene el informe final del día.
     */
    @GetMapping("/final-del-dia")
    public String generarInformeFinalDelDia() {
        Date fechaActual = new Date();
        List<Venta> ventasDelDia = ventaService.obtenerVentasDelDia(fechaActual);
        double montoTotalVentas = ventaService.calcularMontoTotalVentas(ventasDelDia);

        StringBuilder informe = new StringBuilder();
        informe.append("Informe final del día:\n");
        informe.append("Fecha: ").append(fechaActual).append("\n");
        informe.append("Monto total de ventas: ").append(montoTotalVentas).append("\n");
        informe.append("Detalles de las ventas del día:\n");

        for (Venta venta : ventasDelDia) {
            informe.append("Venta ID: ").append(venta.getId()).append("\n");
            informe.append("Fecha de venta: ").append(venta.getFecha()).append("\n");
            informe.append("Monto total: ").append(venta.getMontoTotal()).append("\n");

            for (ProductoVendido productoVendido : venta.getProductosVendidos()) {
                informe.append("Producto vendido: ").append(productoVendido.getProducto().getDescripcion());
                informe.append(", Cantidad: ").append(productoVendido.getCantidad()).append("\n");
            }
            informe.append("\n");
        }

        return informe.toString();
    }
}
