package com.dev.backend.service;

import com.dev.backend.dto.ProductDto;
import com.dev.backend.model.GenericModel;

import java.util.List;

public interface ProductService extends GenericModel<ProductDto> {

    List<ProductDto> findAllBy(Integer brandId, Integer categoryId);
}
