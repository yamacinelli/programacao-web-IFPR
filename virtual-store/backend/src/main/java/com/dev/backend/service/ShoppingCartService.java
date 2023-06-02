package com.dev.backend.service;

import com.dev.backend.model.ShoppingCart;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService implements GenericModel<ShoppingCart> {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart save(ShoppingCart model) {
        return shoppingCartRepository.saveAndFlush(model);
    }

    @Override
    public List<ShoppingCart> saveAll(List<ShoppingCart> models) {
        return shoppingCartRepository.saveAllAndFlush(models);
    }

    @Override
    public ShoppingCart findById(Integer id) {
        return shoppingCartRepository.findById(id).orElse(null);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public ShoppingCart update(ShoppingCart model) {
        return shoppingCartRepository.saveAndFlush(model);
    }
}
