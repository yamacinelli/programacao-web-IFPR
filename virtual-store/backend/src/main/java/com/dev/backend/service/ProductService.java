package com.dev.backend.service;

import com.dev.backend.dto.ProductDto;
import com.dev.backend.model.Product;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.ProductRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements GenericModel<ProductDto> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto save(ProductDto dto) {
        return ParseUtils.parse(
                productRepository.saveAndFlush(ParseUtils.parse(dto, Product.class)),
                ProductDto.class);
    }

    @Override
    public List<ProductDto> saveAll(List<ProductDto> dtos) {
        return ParseUtils.parse(
                productRepository.saveAllAndFlush(ParseUtils.parse(dtos, Product.class)),
                ProductDto.class);
    }

    @Override
    public ProductDto findById(Integer id) {
        return ParseUtils.parse(productRepository.findById(id).orElse(null), ProductDto.class);
    }

    @Override
    public List<ProductDto> findAll() {
        return ParseUtils.parse(productRepository.findAll(), ProductDto.class);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto update(ProductDto dto) {
        return ParseUtils.parse(
                productRepository.saveAndFlush(ParseUtils.parse(dto, Product.class)),
                ProductDto.class);
    }
}
