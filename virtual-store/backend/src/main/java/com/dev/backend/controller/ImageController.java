package com.dev.backend.controller;

import com.dev.backend.model.Image;
import com.dev.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService ImageService;

    @PostMapping
    ResponseEntity<Image> save(@RequestBody Image model) {
        return ResponseEntity.ok(ImageService.save(model));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<Image>> saveAll(@RequestBody List<Image> models) {
        return ResponseEntity.ok(ImageService.saveAll(models));
    }

    @GetMapping("/{id}")
    ResponseEntity<Image> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(ImageService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<Image>> findAll() {
        return ResponseEntity.ok(ImageService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        ImageService.delete(id);
    }

    @PutMapping
    ResponseEntity<Image> update(@RequestBody Image model) {
        return ResponseEntity.ok(ImageService.update(model));
    }
}
