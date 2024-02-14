package com.example.prueba.Controller;

import com.example.prueba.model.RegistroAuditoria;
import com.example.prueba.respository.RegistroAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {

    @Autowired
    private RegistroAuditoriaRepository registroAuditoriaRepository;

    /**
     * Obtiene todos los registros de auditoría.
     *
     * @return Lista de objetos RegistroAuditoria
     */
    @GetMapping
    public List<RegistroAuditoria> obtenerRegistrosAuditoria() {
        return registroAuditoriaRepository.findAll();
    }
}
