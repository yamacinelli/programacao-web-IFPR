package com.dev.backend.controller;

import com.dev.backend.model.Product;
import com.dev.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    ResponseEntity<Product> save(@RequestBody Product model) {
        return ResponseEntity.ok(productService.save(model));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<Product>> saveAll(@RequestBody List<Product> models) {
        return ResponseEntity.ok(productService.saveAll(models));
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @PutMapping
    ResponseEntity<Product> update(@RequestBody Product model) {
        return ResponseEntity.ok(productService.update(model));
    }
}
