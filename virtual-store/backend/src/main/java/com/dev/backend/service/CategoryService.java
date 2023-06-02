package com.dev.backend.service;

import com.dev.backend.model.Category;
import com.dev.backend.repository.CategoryRepository;
import com.dev.backend.model.GenericModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements GenericModel<Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category model) {
        return categoryRepository.saveAndFlush(model);
    }

    @Override
    public List<Category> saveAll(List<Category> models) {
        return categoryRepository.saveAllAndFlush(models);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Category model) {
        return categoryRepository.saveAndFlush(model);
    }
}
