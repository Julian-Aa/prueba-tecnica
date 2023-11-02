package com.example.angular.services;

import com.example.angular.model.Articulo;
import com.example.angular.respository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;

    public List<Articulo> findAll() {
        return articuloRepository.findAll();
    }

    public Articulo findBYId(Long id) {
        return articuloRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        articuloRepository.deleteById(id);
    }

    public Articulo save(Articulo articulo) {
      return  articuloRepository.save(articulo);
    }


}
