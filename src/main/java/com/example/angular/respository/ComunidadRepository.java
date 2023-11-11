package com.example.angular.respository;

import com.example.angular.model.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, Long> {

    List<Comunidad> findByUsuarioId(Long usuarioId);


}
