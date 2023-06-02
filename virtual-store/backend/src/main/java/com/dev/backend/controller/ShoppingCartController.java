package com.dev.backend.controller;

import com.dev.backend.model.ShoppingCart;
import com.dev.backend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping
    ResponseEntity<ShoppingCart> save(@RequestBody ShoppingCart model) {
        return ResponseEntity.ok(shoppingCartService.save(model));
    }

    @PostMapping("/save-all")
    ResponseEntity<List<ShoppingCart>> saveAll(@RequestBody List<ShoppingCart> models) {
        return ResponseEntity.ok(shoppingCartService.saveAll(models));
    }

    @GetMapping("/{id}")
    ResponseEntity<ShoppingCart> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(shoppingCartService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<ShoppingCart>> findAll() {
        return ResponseEntity.ok(shoppingCartService.findAll());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        shoppingCartService.delete(id);
    }

    @PutMapping
    ResponseEntity<ShoppingCart> update(@RequestBody ShoppingCart model) {
        return ResponseEntity.ok(shoppingCartService.update(model));
    }
}
