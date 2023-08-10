package com.dev.backend.service;

import com.dev.backend.dto.ImageDto;
import com.dev.backend.model.Image;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.ImageRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements GenericModel<ImageDto> {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageDto save(ImageDto dto) {
        return ParseUtils.parse(
                imageRepository.saveAndFlush(ParseUtils.parse(dto, Image.class)),
                ImageDto.class);
    }

    @Override
    public List<ImageDto> saveAll(List<ImageDto> dtos) {
        return ParseUtils.parse(
                imageRepository.saveAllAndFlush(ParseUtils.parse(dtos, Image.class)),
                ImageDto.class);
    }

    @Override
    public ImageDto findById(Integer id) {
        return ParseUtils.parse(imageRepository.findById(id).orElse(null), ImageDto.class);
    }

    @Override
    public List<ImageDto> findAll() {
        return ParseUtils.parse(imageRepository.findAll(), ImageDto.class);
    }

    @Override
    public void delete(Integer id) {
        imageRepository.deleteById(id);
    }

    @Override
    public ImageDto update(ImageDto dto) {
        return ParseUtils.parse(
                imageRepository.saveAndFlush(ParseUtils.parse(dto, Image.class)),
                ImageDto.class);
    }
}
