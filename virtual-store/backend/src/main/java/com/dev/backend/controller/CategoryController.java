package com.dev.backend.controller;

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
    ResponseEntity<Category> save(@RequestBody Category model) {
        return ResponseEntity.ok(categoryService.save(model));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<Category>> saveAll(@RequestBody List<Category> models) {
        return ResponseEntity.ok(categoryService.saveAll(models));
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }

    @PutMapping
    ResponseEntity<Category> update(@RequestBody Category model) {
        return ResponseEntity.ok(categoryService.update(model));
    }
}
