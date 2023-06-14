package com.dev.backend.controller;

import com.dev.backend.dto.PermissionDto;
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
    ResponseEntity<PermissionDto> save(@RequestBody PermissionDto dto) {
        return ResponseEntity.ok(permissionService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<PermissionDto>> saveAll(@RequestBody List<PermissionDto> dtos) {
        return ResponseEntity.ok(permissionService.saveAll(dtos));
    }

    @GetMapping("/{id}")
    ResponseEntity<PermissionDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(permissionService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<PermissionDto>> findAll() {
        return ResponseEntity.ok(permissionService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        permissionService.delete(id);
    }

    @PutMapping
    ResponseEntity<PermissionDto> update(@RequestBody PermissionDto dto) {
        return ResponseEntity.ok(permissionService.update(dto));
    }
}
