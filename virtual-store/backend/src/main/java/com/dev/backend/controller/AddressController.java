package com.dev.backend.controller;

import com.dev.backend.model.Address;
import com.dev.backend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    ResponseEntity<Address> save(@RequestBody Address model) {
        return ResponseEntity.ok(addressService.save(model));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<Address>> saveAll(@RequestBody List<Address> models) {
        return ResponseEntity.ok(addressService.saveAll(models));
    }

    @GetMapping("/{id}")
    ResponseEntity<Address> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }

    @PutMapping
    ResponseEntity<Address> update(@RequestBody Address model) {
        return ResponseEntity.ok(addressService.update(model));
    }
}
