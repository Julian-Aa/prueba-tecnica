package com.example.prueba.Controller;

import com.example.prueba.model.Usuario;
import com.example.prueba.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la gestión de usuarios.
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene todos los usuarios.
     *
     * @return ResponseEntity con la lista de usuarios.
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> show() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id ID del usuario a buscar.
     * @return ResponseEntity con el usuario encontrado o una respuesta de error si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Usuario usuario = usuarioService.finBy(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Inicia sesión de un usuario.
     *
     * @param usuario Objeto Usuario que contiene las credenciales de inicio de sesión.
     * @return ResponseEntity con el usuario autenticado si las credenciales son válidas; de lo contrario, una respuesta de error.
     */
    @PostMapping("/login")
    public ResponseEntity<Usuario> getUsuario(@RequestBody Usuario usuario) {
        Usuario usu = usuarioService.login(usuario.getCorreo(), usuario.getContrasena());
        if (usu != null) {
            return ResponseEntity.ok(usu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param usuario Objeto Usuario que contiene los datos del nuevo usuario.
     * @return ResponseEntity con el usuario creado o un mensaje de error si el correo electrónico ya existe.
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Usuario usuario) {
        if (usuarioService.existsByCorreo(usuario.getCorreo())) {
            return ResponseEntity.badRequest().body("El correo electrónico ya existe.");
        } else {
            Usuario createdUser = usuarioService.save(usuario);
            return ResponseEntity.ok(createdUser);
        }
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param id      ID del usuario a actualizar.
     * @param usuario Objeto Usuario con los datos actualizados.
     * @return El usuario actualizado.
     */
    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.save(usuario);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @return ResponseEntity con un mensaje indicando que la eliminación ha sido exitosa.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usuarioService.dele(id);
        return ResponseEntity.noContent().build();
    }

}
