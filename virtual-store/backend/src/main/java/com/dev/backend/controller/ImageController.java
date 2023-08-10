package com.dev.backend.controller;

import com.dev.backend.dto.ImageDto;
import com.dev.backend.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageService ImageService;

    public ImageController(com.dev.backend.service.ImageService imageService) {
        ImageService = imageService;
    }

    @PostMapping
    ResponseEntity<ImageDto> save(@RequestBody ImageDto dto) {
        return ResponseEntity.ok(ImageService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<ImageDto>> saveAll(@RequestBody List<ImageDto> dtos) {
        return ResponseEntity.ok(ImageService.saveAll(dtos));
    }

    @GetMapping("/{id}")
    ResponseEntity<ImageDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(ImageService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<ImageDto>> findAll() {
        return ResponseEntity.ok(ImageService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        ImageService.delete(id);
    }

    @PutMapping
    ResponseEntity<ImageDto> update(@RequestBody ImageDto dto) {
        return ResponseEntity.ok(ImageService.update(dto));
    }
}
