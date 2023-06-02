package com.dev.backend.service;

import com.dev.backend.model.Brand;
import com.dev.backend.repository.BrandRepository;
import com.dev.backend.model.GenericModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements GenericModel<Brand> {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand save(Brand model) {
        return brandRepository.saveAndFlush(model);
    }

    @Override
    public List<Brand> saveAll(List<Brand> models) {
        return brandRepository.saveAllAndFlush(models);
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Brand update(Brand model) {
        return brandRepository.saveAndFlush(model);
    }
}
