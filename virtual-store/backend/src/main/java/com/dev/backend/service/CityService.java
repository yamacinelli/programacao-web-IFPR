package com.dev.backend.service;

import com.dev.backend.model.City;
import com.dev.backend.repository.CityRepository;
import com.dev.backend.model.GenericModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements GenericModel<City> {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City model) {
        return cityRepository.saveAndFlush(model);
    }

    @Override
    public List<City> saveAll(List<City> models) {
        return cityRepository.saveAllAndFlush(models);
    }

    @Override
    public City findById(Integer id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City update(City model) {
        return cityRepository.saveAndFlush(model);
    }
}
