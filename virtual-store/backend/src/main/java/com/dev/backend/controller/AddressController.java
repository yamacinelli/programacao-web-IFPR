package com.dev.backend.controller;

import com.dev.backend.dto.AddressDto;
import com.dev.backend.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    public final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    ResponseEntity<AddressDto> save(@RequestBody AddressDto dto) {
        return ResponseEntity.ok(addressService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<AddressDto>> saveAll(@RequestBody List<AddressDto> dtos) {
        return ResponseEntity.ok(addressService.saveAll(dtos));
    }

    @GetMapping("/{id}")
    ResponseEntity<AddressDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<AddressDto>> findAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }

    @PutMapping
    ResponseEntity<AddressDto> update(@RequestBody AddressDto dto) {
        return ResponseEntity.ok(addressService.update(dto));
    }
}
