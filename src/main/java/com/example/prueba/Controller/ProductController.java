package com.example.prueba.Controller;

import com.example.prueba.model.CrearProductoRequest;
import com.example.prueba.model.Producto;
import com.example.prueba.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la gestión de productos.
 */
@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductoService productoService;

    /**
     * Obtiene todos los productos.
     *
     * @return ResponseEntity con la lista de productos.
     */
    @GetMapping
    public ResponseEntity<List<Producto>> show() {
        return ResponseEntity.ok(productoService.findAll());
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id ID del producto a buscar.
     * @return ResponseEntity con el producto encontrado o una respuesta de error si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id) {
        Producto producto = productoService.finBy(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo producto.
     *
     * @param request Objeto CrearProductoRequest que contiene el producto a crear y el usuario que lo crea.
     * @return ResponseEntity con el producto creado.
     */
    @PostMapping
    public ResponseEntity<Producto> createProduct(@RequestBody CrearProductoRequest request) {
        Producto producto = request.getProducto();
        String usuario = request.getUsuario();
        Producto createdProduct = productoService.crearProducto(producto, usuario);

        return ResponseEntity.ok(createdProduct);
    }

    /**
     * Actualiza un producto existente.
     *
     * @param id       ID del producto a actualizar.
     * @param producto Objeto Producto con los datos actualizados.
     * @return El producto actualizado.
     */
    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.save(producto);
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param id ID del producto a eliminar.
     * @return ResponseEntity con un mensaje indicando que la eliminación ha sido exitosa.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productoService.dele(id);
        return ResponseEntity.noContent().build();
    }

}
