package com.dev.backend.service;

import com.dev.backend.dto.PeopleDto;
import com.dev.backend.model.GenericModel;

import java.util.List;

public interface PeopleService extends GenericModel<PeopleDto> {

    List<PeopleDto> findAllBy(Integer cityId, Integer permissionId);
}
