package com.dev.backend.service;

import com.dev.backend.dto.CityDto;
import com.dev.backend.model.GenericModel;

public interface CityService extends GenericModel<CityDto> {

    CityDto findByNameAndStateAbbreviation(String name, String stateAbbreviation);
}
