package com.example.angular.respository;

import com.example.angular.model.Comentario;
import com.example.angular.model.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository <Comentario, Long> {

    // Necesito listar los comentarios por comunidad
    List<Comentario> findByComunidadId(Long comunidadId);

}
