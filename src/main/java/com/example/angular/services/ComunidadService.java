package com.example.angular.services;

import com.example.angular.model.Comunidad;
import com.example.angular.respository.ComunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunidadService {

    @Autowired
    ComunidadRepository comunidadRepository;

    public List<Comunidad> findAll (){
        return comunidadRepository.findAll();
    }

    public Comunidad finById (Long id){
        return comunidadRepository.findById(id).orElse(null);
    }

    public Comunidad save(Comunidad comunidad) {return comunidadRepository.save(comunidad);}

    public List<Comunidad> getComunidadesByUserId(Long usuarioId){
        return comunidadRepository.findByUsuarioId(usuarioId);
    }

    public void delete(Long id ){comunidadRepository.deleteById(id);}

}
