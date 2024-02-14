package com.example.prueba.respository;

import com.example.prueba.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de repositorio para la entidad Usuario.
 * Proporciona métodos para acceder y manipular datos relacionados con los usuarios.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Verifica si existe un usuario con el correo electrónico dado.
     *
     * @param correo Correo electrónico del usuario a buscar.
     * @return true si existe un usuario con el correo electrónico dado, false de lo contrario.
     */
    boolean existsByCorreo(String correo);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo Correo electrónico del usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra.
     */
    Usuario findUsuarioByCorreo(String correo);
}
