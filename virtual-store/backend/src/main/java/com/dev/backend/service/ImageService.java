package com.dev.backend.service;

import com.dev.backend.model.Image;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements GenericModel<Image> {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image save(Image model) {
        return imageRepository.saveAndFlush(model);
    }

    @Override
    public List<Image> saveAll(List<Image> models) {
        return imageRepository.saveAllAndFlush(models);
    }

    @Override
    public Image findById(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image update(Image model) {
        return imageRepository.saveAndFlush(model);
    }
}
