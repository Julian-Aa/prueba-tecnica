package com.example.prueba.services;

import com.example.prueba.model.Usuario;
import com.example.prueba.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de usuarios.
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtiene todos los usuarios.
     *
     * @return Una lista de todos los usuarios.
     */
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    public Usuario finBy(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un usuario.
     *
     * @param usuario El usuario a guardar.
     * @return El usuario guardado.
     */
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id El ID del usuario a eliminar.
     */
    public void dele(Long id) {
        usuarioRepository.deleteById(id);
    }

    /**
     * Verifica si existe un usuario con el correo electrónico dado.
     *
     * @param correo Correo electrónico del usuario a verificar.
     * @return true si existe un usuario con el correo electrónico dado, false de lo contrario.
     */
    public boolean existsByCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo Correo electrónico del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    public Usuario findUsuarioByCorreo(String correo) {
        return usuarioRepository.findUsuarioByCorreo(correo);
    }

    /**
     * Realiza el proceso de inicio de sesión para un usuario.
     *
     * @param correo     Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @return El usuario si las credenciales son válidas, null de lo contrario.
     */
    public Usuario login(String correo, String contrasena) {
        Usuario usuario = usuarioRepository.findUsuarioByCorreo(correo);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        } else {
            return null;
        }
    }
}
