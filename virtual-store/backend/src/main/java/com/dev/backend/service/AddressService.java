package com.dev.backend.service;

import com.dev.backend.dto.AddressDto;
import com.dev.backend.model.Address;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.AddressRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements GenericModel<AddressDto> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDto save(AddressDto dto) {
        return ParseUtils.parse(
                addressRepository.saveAndFlush(ParseUtils.parse(dto, Address.class)),
                AddressDto.class);
    }

    @Override
    public List<AddressDto> saveAll(List<AddressDto> dtos) {
        return ParseUtils.parse(
                addressRepository.saveAllAndFlush(ParseUtils.parse(dtos, Address.class)),
                AddressDto.class);
    }

    @Override
    public AddressDto findById(Integer id) {
        return ParseUtils.parse(addressRepository.findById(id).orElse(null), AddressDto.class);
    }

    @Override
    public List<AddressDto> findAll() {
        return ParseUtils.parse(addressRepository.findAll(), AddressDto.class);
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDto update(AddressDto dto) {
        return ParseUtils.parse(
                addressRepository.saveAndFlush(ParseUtils.parse(dto, Address.class)),
                AddressDto.class);
    }
}
