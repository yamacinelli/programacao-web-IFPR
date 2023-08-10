package com.dev.backend.service;

import com.dev.backend.dto.BrandDto;
import com.dev.backend.model.Brand;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.BrandRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements GenericModel<BrandDto> {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandDto save(BrandDto dto) {
        return ParseUtils.parse(
                brandRepository.saveAndFlush(ParseUtils.parse(dto, Brand.class)),
                BrandDto.class);
    }

    @Override
    public List<BrandDto> saveAll(List<BrandDto> dtos) {
        return ParseUtils.parse(
                brandRepository.saveAllAndFlush(ParseUtils.parse(dtos, Brand.class)),
                BrandDto.class);
    }

    @Override
    public BrandDto findById(Integer id) {
        return ParseUtils.parse(brandRepository.findById(id).orElse(null), BrandDto.class);
    }

    @Override
    public List<BrandDto> findAll() {
        return ParseUtils.parse(brandRepository.findAll(), BrandDto.class);
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public BrandDto update(BrandDto dto) {
        return ParseUtils.parse(
                brandRepository.saveAndFlush(ParseUtils.parse(dto, Brand.class)),
                BrandDto.class);
    }
}
