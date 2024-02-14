package com.example.prueba.services;

import com.example.prueba.model.RegistroAuditoria;
import com.example.prueba.respository.AuditRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Servicio para realizar auditorías.
 */
@Service
public class AuditService {
    private final AuditRepository auditRepository;

    /**
     * Constructor del servicio AuditService.
     *
     * @param auditRepository Repositorio de auditoría.
     */
    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    /**
     * Realiza una auditoría con la acción y el usuario especificados.
     *
     * @param action La acción realizada.
     * @param user   El usuario que realizó la acción.
     */
    public void audit(String action, String user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        RegistroAuditoria audit = new RegistroAuditoria();
        audit.setAccion(action);
        audit.setUsuario(user);
        audit.setFecha(date);

        auditRepository.save(audit);
    }
}
