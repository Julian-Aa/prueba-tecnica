package com.example.prueba.respository;

import com.example.prueba.model.ActividadRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Interfaz de repositorio para la entidad ActividadRegistro.
 * Proporciona métodos para acceder y manipular datos relacionados con las actividades de registro.
 */
public interface ActividadRegistroRepository extends JpaRepository<ActividadRegistro, Long> {

    /**
     * Busca actividades de registro por tipo de acción.
     *
     * @param tipoAccion El tipo de acción de las actividades de registro a buscar.
     * @return Una lista de actividades de registro que coinciden con el tipo de acción especificado.
     */
    List<ActividadRegistro> findByTipoAccion(String tipoAccion);
}
