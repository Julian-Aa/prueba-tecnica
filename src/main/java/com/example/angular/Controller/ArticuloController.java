package com.example.angular.Controller;

import com.cloudinary.utils.ObjectUtils;
import com.example.angular.config.CloudinaryConfig;
import com.example.angular.model.Articulo;
import com.example.angular.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticuloController {
    private String imagen = "";

    @Autowired
    private ArticuloService articuloService;
    @Autowired
    private CloudinaryConfig cloudc;

    @GetMapping
    public ResponseEntity<List<Articulo>> show() {
        return ResponseEntity.ok(articuloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> getById(@PathVariable Long id) {
        Articulo articulo = articuloService.findBYId(id);
        if (articulo != null) {
            return ResponseEntity.ok(articulo);
        } else {
            return ResponseEntity.notFound().build();
        }
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

    @PostMapping
    public ResponseEntity<?> createArticulo(@RequestBody Articulo articulo) {
        Articulo createdArticulo = articuloService.save(articulo);
        return ResponseEntity.ok(createdArticulo);
    }

    @PutMapping("/{id}")
    public Articulo update(@PathVariable Long id, @RequestBody Articulo articulo) {
        articulo.setId(id);
        return articuloService.save(articulo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        articuloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
