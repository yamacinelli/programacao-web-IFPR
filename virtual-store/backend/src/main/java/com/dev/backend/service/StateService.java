package com.dev.backend.service;

import com.dev.backend.dto.StateDto;
import com.dev.backend.model.GenericModel;

public interface StateService extends GenericModel<StateDto> {

    StateDto findByNameAndAbbreviation(String name, String abbreviation);
}
