package com.dev.backend.controller;

import com.dev.backend.dto.ShoppingCartDto;
import com.dev.backend.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    ResponseEntity<ShoppingCartDto> save(@RequestBody ShoppingCartDto dto) {
        return ResponseEntity.ok(shoppingCartService.save(dto));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<ShoppingCartDto>> saveAll(@RequestBody List<ShoppingCartDto> dtos) {
        return ResponseEntity.ok(shoppingCartService.saveAll(dtos));
    }

    @GetMapping("/{id}")
    ResponseEntity<ShoppingCartDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(shoppingCartService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<ShoppingCartDto>> findAll(@RequestParam(required = false) Integer people, @RequestParam(required = false) Date start,
                                                  @RequestParam(required = false) Date end, @RequestParam(required = false) String situation) {
        return ResponseEntity.ok(shoppingCartService.findAllBy(people, start, end, situation));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        shoppingCartService.delete(id);
    }

    @PutMapping
    ResponseEntity<ShoppingCartDto> update(@RequestBody ShoppingCartDto dto) {
        return ResponseEntity.ok(shoppingCartService.update(dto));
    }
}
