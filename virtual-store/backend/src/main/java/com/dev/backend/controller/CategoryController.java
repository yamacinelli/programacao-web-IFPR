package com.dev.backend.controller;

import com.dev.backend.dto.CategoryDto;
import com.dev.backend.model.Category;
import com.dev.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    ResponseEntity<CategoryDto> save(@RequestBody CategoryDto dto) {
        return ResponseEntity.ok(categoryService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<CategoryDto>> saveAll(@RequestBody List<CategoryDto> dtos) {
        return ResponseEntity.ok(categoryService.saveAll(dtos));
    }

    @GetMapping("/{id}")
    ResponseEntity<CategoryDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<CategoryDto>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }

    @PutMapping
    ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto) {
        return ResponseEntity.ok(categoryService.update(dto));
    }
}
