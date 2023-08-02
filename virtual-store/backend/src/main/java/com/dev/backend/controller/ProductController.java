package com.dev.backend.controller;

import com.dev.backend.dto.ProductDto;
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
    ResponseEntity<ProductDto> save(@RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<ProductDto>> saveAll(@RequestBody List<ProductDto> dtos) {
        return ResponseEntity.ok(productService.saveAll(dtos));
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<ProductDto>> findAll(@RequestParam(required = false) Integer brand, @RequestParam(required = false) Integer category) {
        return ResponseEntity.ok(productService.findAllBy(brand, category));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @PutMapping
    ResponseEntity<ProductDto> update(@RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.update(dto));
    }
}
