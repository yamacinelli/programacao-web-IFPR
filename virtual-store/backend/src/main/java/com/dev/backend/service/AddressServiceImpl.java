package com.dev.backend.service;

import com.dev.backend.dto.AddressDto;
import com.dev.backend.model.Address;
import com.dev.backend.repository.AddressRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final CityServiceImpl cityServiceImpl;

    public AddressServiceImpl(AddressRepository addressRepository, CityServiceImpl cityServiceImpl) {
        this.addressRepository = addressRepository;
        this.cityServiceImpl = cityServiceImpl;
    }

    @Override
    public AddressDto save(AddressDto dto) {
        // Save City
        dto.setCity(cityServiceImpl.save(dto.getCity()));
        // Save Address
        AddressDto addressDto = findByStreetAndDistrictAndCepAndCityName(dto.getStreet(), dto.getDistrict(), dto.getCep(), dto.getCity().getName());
        if (addressDto != null) {
            return addressDto;
        }
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

    @Override
    public AddressDto findByStreetAndDistrictAndCepAndCityName(String street, String district, String cep, String cityName) {
        return ParseUtils.parse(addressRepository.findByStreetAndDistrictAndCepAndCityName(street, district, cep, cityName), AddressDto.class);
    }
}
