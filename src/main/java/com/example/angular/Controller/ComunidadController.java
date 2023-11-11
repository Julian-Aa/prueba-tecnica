package com.example.angular.Controller;


import com.example.angular.model.Comentario;
import com.example.angular.model.Comunidad;
import com.example.angular.services.ComunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/comunidades")
@CrossOrigin(origins = "http://localhost:4200")
public class ComunidadController {
    @Autowired
    private ComunidadService comunidadService;


    //GESTION COMENTARIOS
    @GetMapping("comentarios/{comunidadId}")
    public ResponseEntity<List<Comentario>>getComentarioByComunidadId(@PathVariable Long comunidadId) {
        List<Comentario> comentarios = comunidadService.findComnetariosByComunidadId(comunidadId);
        if (comentarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(comentarios);
        }
    }

    @PostMapping("comentarios/nuevo")
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario nuevoComentario) {
        // Aquí podrías realizar validaciones adicionales antes de guardar el comentario
        Comentario creado = comunidadService.guardarComentario(nuevoComentario);

        // Devuelve un ResponseEntity con el comentario creado y un código 201 (CREATED)
        return ResponseEntity.status(201).body(creado);
    }

    //GESTION COMUNIDADES
    @GetMapping
    public ResponseEntity<List<Comunidad>> getAllComunidades() {

        return ResponseEntity.ok(comunidadService.findAll());
    }

   @GetMapping("/{id}")
    public ResponseEntity<Comunidad> getComunidadById(@PathVariable Long id) {
        Comunidad comunidad = comunidadService.finById(id);
        if (comunidad != null) {
            return ResponseEntity.ok(comunidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{usuarioId}")
    public ResponseEntity<List<Comunidad>> getByCreadorId(@PathVariable Long usuarioId){
        List<Comunidad> comunidades = comunidadService.getComunidadesByUserId(usuarioId);
        return ResponseEntity.ok(comunidades);
    }

 @PostMapping
    public ResponseEntity<Comunidad> createComunidad(@RequestBody Comunidad comunidad) {
        Comunidad createdComunidad = comunidadService.save(comunidad);
        return ResponseEntity.ok(createdComunidad);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Comunidad> updateComunidad(@PathVariable Long id, @RequestBody Comunidad comunidad) {
        comunidad.setId(id);
        Comunidad updatedComunidad = comunidadService.save(comunidad);
        return ResponseEntity.ok(updatedComunidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComunidad(@PathVariable Long id) {
        comunidadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


