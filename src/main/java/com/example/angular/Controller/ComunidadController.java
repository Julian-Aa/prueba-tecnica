package com.example.angular.Controller;


import com.cloudinary.utils.ObjectUtils;
import com.example.angular.config.CloudinaryConfig;
import com.example.angular.model.Articulo;
import com.example.angular.model.Comentario;
import com.example.angular.model.Comunidad;
import com.example.angular.services.ComentarioService;
import com.example.angular.services.ComunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comunidades")
@CrossOrigin(origins = "http://localhost:4200")
public class ComunidadController {

    @Autowired
    private CloudinaryConfig cloudc;
    @Autowired
    private ComunidadService comunidadService;
    @Autowired
    private ComentarioService comentarioService;
    private String imagen = "";

    //GESTION COMENTARIOS
    @GetMapping("/comentarios/{id}")
    public ResponseEntity<List<Comentario>> getComentarioByComunidadId(@PathVariable Long id) {
        List<Comentario> comentarios = comunidadService.findComnetariosByComunidadId(id);
        if (comentarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(comentarios);
        }
    }

    @PostMapping("/crearComentario")
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario comentario) {
        Comentario creado = comunidadService.guardarComentario(comentario);
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
        return ResponseEntity.ok(comunidad);
    }

    @GetMapping("/user/{usuarioId}")
    public ResponseEntity<List<Comunidad>> getByCreadorId(@PathVariable Long usuarioId) {
        List<Comunidad> comunidades = comunidadService.getComunidadesByUserId(usuarioId);
        return ResponseEntity.ok(comunidades);
    }

    @PostMapping
    public ResponseEntity<Comunidad> createComunidad(@RequestBody Comunidad comunidad) {
        comunidad.setImagenUrl(imagen);
        Comunidad createdComunidad = comunidadService.save(comunidad);
        return ResponseEntity.ok(createdComunidad);
    }

    @PostMapping("/comentario")
    public ResponseEntity<Comentario> createComentario(@RequestBody Comentario comentario) {
        Comentario createdComentario = comentarioService.save(comentario);
        return ResponseEntity.ok(createdComentario);
    }

    @PostMapping("/image-rest")
    public String addArticulos(@RequestParam("file") MultipartFile file) {
        System.out.println("SI ESTA ENTRANDO");
        try {
            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            System.out.println(uploadResult.get("url").toString());
            imagen = uploadResult.get("url").toString();
            return uploadResult.get("url").toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "SI ";
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


