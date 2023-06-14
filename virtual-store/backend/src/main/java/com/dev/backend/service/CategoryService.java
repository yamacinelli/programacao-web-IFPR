package com.dev.backend.service;

import com.dev.backend.dto.CategoryDto;
import com.dev.backend.model.Category;
import com.dev.backend.repository.CategoryRepository;
import com.dev.backend.model.GenericModel;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements GenericModel<CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto dto) {
        return ParseUtils.parse(
                categoryRepository.saveAndFlush(ParseUtils.parse(dto, Category.class)),
                CategoryDto.class);
    }

    @Override
    public List<CategoryDto> saveAll(List<CategoryDto> dtos) {
        return ParseUtils.parse(
                categoryRepository.saveAllAndFlush(ParseUtils.parse(dtos, Category.class)),
                CategoryDto.class);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return ParseUtils.parse(categoryRepository.findById(id).orElse(null), CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAll() {
        return ParseUtils.parse(categoryRepository.findAll(), CategoryDto.class);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto update(CategoryDto dto) {
        return ParseUtils.parse(
                categoryRepository.saveAndFlush(ParseUtils.parse(dto, Category.class)),
                CategoryDto.class);
    }
}
