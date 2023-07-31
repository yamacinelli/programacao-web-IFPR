package com.dev.backend.controller;

import com.dev.backend.dto.PeopleDto;
import com.dev.backend.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping
    ResponseEntity<PeopleDto> save(@RequestBody PeopleDto dto) {
        return ResponseEntity.ok(peopleService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<PeopleDto>> saveAll(@RequestBody List<PeopleDto> dtos) {
        return ResponseEntity.ok(peopleService.saveAll(dtos));
    }

    @GetMapping("/{id}")
    ResponseEntity<PeopleDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(peopleService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<PeopleDto>> findAll(@RequestParam(required = false) Integer city, @RequestParam(required = false) Integer permission) {
        return ResponseEntity.ok(peopleService.findAllBy(city, permission));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        peopleService.delete(id);
    }

    @PutMapping
    ResponseEntity<PeopleDto> update(@RequestBody PeopleDto dto) {
        return ResponseEntity.ok(peopleService.update(dto));
    }
}
