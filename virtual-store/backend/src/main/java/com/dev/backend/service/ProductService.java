package com.dev.backend.service;

import com.dev.backend.model.Product;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements GenericModel<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product model) {
        return productRepository.saveAndFlush(model);
    }

    @Override
    public List<Product> saveAll(List<Product> models) {
        return productRepository.saveAllAndFlush(models);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product model) {
        return productRepository.saveAndFlush(model);
    }
}
