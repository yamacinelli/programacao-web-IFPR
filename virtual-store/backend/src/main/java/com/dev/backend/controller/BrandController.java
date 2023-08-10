package com.dev.backend.controller;

import com.dev.backend.dto.BrandDto;
import com.dev.backend.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    ResponseEntity<BrandDto> save(@Valid @RequestBody BrandDto dto) {
        return ResponseEntity.ok(brandService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<BrandDto>> saveAll(@Valid @RequestBody List<BrandDto> dtos) {
        return ResponseEntity.ok(brandService.saveAll(dtos));
    }

    @GetMapping("/{id}")
    ResponseEntity<BrandDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(brandService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<BrandDto>> findAll() {
        return ResponseEntity.ok(brandService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        brandService.delete(id);
    }

    @PutMapping
    ResponseEntity<BrandDto> update(@Valid @RequestBody BrandDto dto) {
        return ResponseEntity.ok(brandService.update(dto));
    }
}
