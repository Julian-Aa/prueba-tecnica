package com.example.angular.services;

import com.example.angular.model.Usuario;
import com.example.angular.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario finBy(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void dele(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean existsByCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    public Usuario findUsuarioByCorreo(String correo) {
        Usuario usuarios = usuarioRepository.findUsuarioByCorreo(correo);
        return usuarios;
    }

    public Usuario login(String correo, String contrasena) {
        Usuario usuarios = usuarioRepository.findUsuarioByCorreo(correo);
        if (usuarios != null && usuarios.getContrasena().equals(contrasena)) {
            return usuarios;
        } else {
            return null;
        }
    }
}
