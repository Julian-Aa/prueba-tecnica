package com.example.prueba.Controller;

import com.example.prueba.model.Usuario;
import com.example.prueba.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la autenticación de usuarios.
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Maneja las solicitudes POST para iniciar sesión de usuario.
     *
     * @param usuario Objeto Usuario que contiene las credenciales de inicio de sesión.
     * @return ResponseEntity con el Usuario autenticado si las credenciales son válidas; de lo contrario, una respuesta de error.
     */
    @PostMapping("/login")
    public ResponseEntity<Usuario> getUsuario(@RequestBody Usuario usuario) {
        Usuario usu = usuarioService.login(usuario.getCorreo(), usuario.getContrasena());
        if (usu != null) {
            System.out.println("Usuario autenticado");
            return ResponseEntity.ok(usu);
        } else {
            System.out.printf("Credenciales inválidas");
            return ResponseEntity.notFound().build();
        }
    }
}
