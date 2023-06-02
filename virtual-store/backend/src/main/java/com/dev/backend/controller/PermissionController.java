package com.dev.backend.controller;

import com.dev.backend.model.Permission;
import com.dev.backend.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    ResponseEntity<Permission> save(@RequestBody Permission model) {
        return ResponseEntity.ok(permissionService.save(model));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<Permission>> saveAll(@RequestBody List<Permission> models) {
        return ResponseEntity.ok(permissionService.saveAll(models));
    }

    @GetMapping("/{id}")
    ResponseEntity<Permission> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(permissionService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<Permission>> findAll() {
        return ResponseEntity.ok(permissionService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        permissionService.delete(id);
    }

    @PutMapping
    ResponseEntity<Permission> update(@RequestBody Permission model) {
        return ResponseEntity.ok(permissionService.update(model));
    }
}
