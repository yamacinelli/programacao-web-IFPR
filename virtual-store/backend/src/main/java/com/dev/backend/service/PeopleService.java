package com.dev.backend.service;

import com.dev.backend.model.People;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService implements GenericModel<People> {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public People save(People model) {
        return peopleRepository.saveAndFlush(model);
    }

    @Override
    public List<People> saveAll(List<People> models) {
        return peopleRepository.saveAllAndFlush(models);
    }

    @Override
    public People findById(Integer id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Override
    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        peopleRepository.deleteById(id);
    }

    @Override
    public People update(People model) {
        return peopleRepository.saveAndFlush(model);
    }
}
