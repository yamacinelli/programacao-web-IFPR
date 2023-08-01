package com.dev.backend.service;

import com.dev.backend.dto.StateDto;
import com.dev.backend.model.State;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.StateRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements GenericModel<StateDto> {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public StateDto save(StateDto dto) {
        StateDto stateDto = findByNameAndAbbreviation(dto.getName(), dto.getAbbreviation());
        if (stateDto != null) {
            return stateDto;
        }
        return ParseUtils.parse(
                stateRepository.saveAndFlush(ParseUtils.parse(dto, State.class)),
                StateDto.class);
    }

    @Override
    public List<StateDto> saveAll(List<StateDto> dtos) {
        return ParseUtils.parse(
                stateRepository.saveAllAndFlush(ParseUtils.parse(dtos, State.class)),
                StateDto.class);
    }

    @Override
    public StateDto findById(Integer id) {
        return ParseUtils.parse(stateRepository.findById(id).orElse(null), StateDto.class);
    }

    @Override
    public List<StateDto> findAll() {
        return ParseUtils.parse(stateRepository.findAll(), StateDto.class);
    }

    @Override
    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }

    @Override
    public StateDto update(StateDto dto) {
        return ParseUtils.parse(
                stateRepository.saveAndFlush(ParseUtils.parse(dto, State.class)),
                StateDto.class);
    }

    public StateDto findByNameAndAbbreviation(String name, String abbreviation) {
        return ParseUtils.parse(
                stateRepository.findByNameAndAbbreviation(name, abbreviation),
                StateDto.class);
    }
}
