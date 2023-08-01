package com.dev.backend.service;

import com.dev.backend.dto.CityDto;
import com.dev.backend.model.City;
import com.dev.backend.repository.CityRepository;
import com.dev.backend.model.GenericModel;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements GenericModel<CityDto> {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateService stateService;

    @Override
    public CityDto save(CityDto dto) {
        // Save State
        dto.setState(stateService.save(dto.getState()));
        // Save City
        CityDto cityDto = findByNameAndStateAbbreviation(dto.getName(), dto.getState().getAbbreviation());
        if (cityDto != null) {
            return cityDto;
        }
        return ParseUtils.parse(
                cityRepository.saveAndFlush(ParseUtils.parse(dto, City.class)),
                CityDto.class);
    }

    @Override
    public List<CityDto> saveAll(List<CityDto> dtos) {
        return ParseUtils.parse(
                cityRepository.saveAllAndFlush(ParseUtils.parse(dtos, City.class)),
                CityDto.class);
    }

    @Override
    public CityDto findById(Integer id) {
        return ParseUtils.parse(cityRepository.findById(id).orElse(null), CityDto.class);
    }

    @Override
    public List<CityDto> findAll() {
        return ParseUtils.parse(cityRepository.findAll(), CityDto.class);
    }

    @Override
    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public CityDto update(CityDto dto) {
        return ParseUtils.parse(
                cityRepository.saveAndFlush(ParseUtils.parse(dto, City.class)),
                CityDto.class);
    }

    public CityDto findByNameAndStateAbbreviation(String name, String stateAbbreviation) {
        return ParseUtils.parse(
                cityRepository.findByNameAndStateAbbreviation(name, stateAbbreviation),
                CityDto.class);
    }
}
