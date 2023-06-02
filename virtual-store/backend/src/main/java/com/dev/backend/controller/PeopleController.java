package com.dev.backend.controller;

import com.dev.backend.model.People;
import com.dev.backend.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping
    ResponseEntity<People> save(@RequestBody People model) {
        return ResponseEntity.ok(peopleService.save(model));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<People>> saveAll(@RequestBody List<People> models) {
        return ResponseEntity.ok(peopleService.saveAll(models));
    }

    @GetMapping("/{id}")
    ResponseEntity<People> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(peopleService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<People>> findAll() {
        return ResponseEntity.ok(peopleService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        peopleService.delete(id);
    }

    @PutMapping
    ResponseEntity<People> update(@RequestBody People model) {
        return ResponseEntity.ok(peopleService.update(model));
    }
}
