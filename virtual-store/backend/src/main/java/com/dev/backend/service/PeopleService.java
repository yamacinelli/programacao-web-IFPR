package com.dev.backend.service;

import com.dev.backend.dto.PeopleDto;
import com.dev.backend.model.GenericModel;
import com.dev.backend.model.People;
import com.dev.backend.repository.PeopleRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService implements GenericModel<PeopleDto> {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public PeopleDto save(PeopleDto dto) {
        return ParseUtils.parse(
                peopleRepository.saveAndFlush(ParseUtils.parse(dto, People.class)),
                PeopleDto.class);
    }

    @Override
    public List<PeopleDto> saveAll(List<PeopleDto> dtos) {
        return ParseUtils.parse(
                peopleRepository.saveAllAndFlush(ParseUtils.parse(dtos, People.class)),
                PeopleDto.class);
    }

    @Override
    public PeopleDto findById(Integer id) {
        return ParseUtils.parse(peopleRepository.findById(id).orElse(null), PeopleDto.class);
    }

    @Override
    public List<PeopleDto> findAll() {
        return ParseUtils.parse(peopleRepository.findAll(), PeopleDto.class);
    }

    @Override
    public void delete(Integer id) {
        peopleRepository.deleteById(id);
    }

    @Override
    public PeopleDto update(PeopleDto dto) {
        return ParseUtils.parse(
                peopleRepository.saveAndFlush(ParseUtils.parse(dto, People.class)),
                PeopleDto.class);
    }
}
