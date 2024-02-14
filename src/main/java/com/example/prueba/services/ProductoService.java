package com.example.prueba.services;

import com.example.prueba.model.Producto;
import com.example.prueba.model.RegistroAuditoria;
import com.example.prueba.respository.ProductoRepository;
import com.example.prueba.respository.RegistroAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Servicio para la gestión de productos.
 */
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private RegistroAuditoriaRepository registroAuditoriaRepository;

    /**
     * Obtiene todos los productos.
     *
     * @return Una lista de todos los productos.
     */
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    /**
     * Busca un producto por su ID.
     *
     * @param id El ID del producto a buscar.
     * @return El producto encontrado, o null si no se encuentra.
     */
    public Producto finBy(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un producto.
     *
     * @param producto El producto a guardar.
     * @return El producto guardado.
     */
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param id El ID del producto a eliminar.
     */
    public void dele(Long id) {
        productoRepository.deleteById(id);
    }

    /**
     * Crea un nuevo producto y registra la acción en el registro de auditoría.
     *
     * @param producto El nuevo producto a crear.
     * @param usuario  El usuario que realiza la acción de creación.
     * @return El producto creado.
     */
    public Producto crearProducto(Producto producto, String usuario) {
        Producto nuevoProducto = productoRepository.save(producto);

        RegistroAuditoria auditoria = new RegistroAuditoria();
        auditoria.setAccion("Creación de producto: " + nuevoProducto.getDescripcion());
        auditoria.setUsuario(usuario);
        auditoria.setFecha(new Date());
        registroAuditoriaRepository.save(auditoria);

        return nuevoProducto;
    }
}
