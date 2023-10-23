package com.example.angular.Controller;

import com.example.angular.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.angular.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> show() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Usuario usuario = usuarioService.finBy(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> getUsuario(@RequestBody Usuario usuario) {
        Usuario usu = usuarioService.login(usuario.getCorreo(), usuario.getContrasena());
        if (usu != null) {
            return ResponseEntity.ok(usu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Usuario usuario) {
        if (usuarioService.existsByCorreo(usuario.getCorreo())) {
            return ResponseEntity.badRequest().body("El correo electrónico ya existe.");
        } else {
            Usuario createdUser = usuarioService.save(usuario);
            return ResponseEntity.ok(createdUser);
        }
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usuarioService.dele(id);
        return ResponseEntity.noContent().build();
    }

}
