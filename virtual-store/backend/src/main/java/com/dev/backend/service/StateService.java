package com.dev.backend.service;

import com.dev.backend.model.State;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements GenericModel<State> {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public State save(State model) {
        return stateRepository.saveAndFlush(model);
    }

    @Override
    public List<State> saveAll(List<State> models) {
        return stateRepository.saveAllAndFlush(models);
    }

    @Override
    public State findById(Integer id) {
        return stateRepository.findById(id).orElse(null);
    }

    @Override
    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }

    @Override
    public State update(State model) {
        return stateRepository.saveAndFlush(model);
    }
}
