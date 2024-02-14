package com.example.prueba.respository;

import com.example.prueba.model.RegistroAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de repositorio para la entidad RegistroAuditoria.
 * Proporciona métodos para acceder y manipular datos relacionados con los registros de auditoría.
 */
@Repository
public interface RegistroAuditoriaRepository extends JpaRepository<RegistroAuditoria, Long> {
}
