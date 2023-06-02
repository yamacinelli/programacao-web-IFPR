package com.dev.backend.controller;

import com.dev.backend.model.Brand;
import com.dev.backend.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    ResponseEntity<Brand> save(@RequestBody Brand model) {
        return ResponseEntity.ok(brandService.save(model));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<Brand>> saveAll(@RequestBody List<Brand> models) {
        return ResponseEntity.ok(brandService.saveAll(models));
    }

    @GetMapping("/{id}")
    ResponseEntity<Brand> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(brandService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<Brand>> findAll() {
        return ResponseEntity.ok(brandService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        brandService.delete(id);
    }

    @PutMapping
    ResponseEntity<Brand> update(@RequestBody Brand model) {
        return ResponseEntity.ok(brandService.update(model));
    }
}
