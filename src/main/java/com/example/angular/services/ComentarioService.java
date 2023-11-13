package com.example.angular.services;

import com.example.angular.model.Comentario;
import com.example.angular.respository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    ComentarioRepository comentarioRepository;
    public Comentario save(Comentario comentario) {
        return  comentarioRepository.save(comentario);
    }
    public List<Comentario> findByComunidadId(Long comunidadId){
        return  comentarioRepository.findByComunidadId(comunidadId);
    }

}
