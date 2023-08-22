package com.dev.backend.service;

import com.dev.backend.dto.ShoppingCartDto;
import com.dev.backend.model.GenericModel;

import java.util.Date;
import java.util.List;

public interface ShoppingCartService extends GenericModel<ShoppingCartDto> {

    List<ShoppingCartDto> findAllBy(Integer peopleId, Date start, Date end, String situation);
}
