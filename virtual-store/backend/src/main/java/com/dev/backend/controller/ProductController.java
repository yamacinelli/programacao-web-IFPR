package com.dev.backend.controller;

import com.dev.backend.dto.ProductDto;
import com.dev.backend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<ProductDto>> saveAll(@Valid @RequestBody List<ProductDto> dtos) {
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
    ResponseEntity<ProductDto> update(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.update(dto));
    }
}
