package com.dev.backend.service;

import com.dev.backend.dto.AddressDto;
import com.dev.backend.model.GenericModel;

public interface AddressService extends GenericModel<AddressDto> {

    AddressDto findByStreetAndDistrictAndCepAndCityName(String street, String district, String cep, String cityName);
}
