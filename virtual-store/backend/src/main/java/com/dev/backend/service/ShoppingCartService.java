package com.dev.backend.service;

import com.dev.backend.dto.ShoppingCartDto;
import com.dev.backend.model.ShoppingCart;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.ShoppingCartRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService implements GenericModel<ShoppingCartDto> {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCartDto save(ShoppingCartDto dto) {
        return ParseUtils.parse(
                shoppingCartRepository.saveAndFlush(ParseUtils.parse(dto, ShoppingCart.class)),
                ShoppingCartDto.class);
    }

    @Override
    public List<ShoppingCartDto> saveAll(List<ShoppingCartDto> dtos) {
        return ParseUtils.parse(
                shoppingCartRepository.saveAllAndFlush(ParseUtils.parse(dtos, ShoppingCart.class)),
                ShoppingCartDto.class);
    }

    @Override
    public ShoppingCartDto findById(Integer id) {
        return ParseUtils.parse(shoppingCartRepository.findById(id).orElse(null), ShoppingCartDto.class);
    }

    @Override
    public List<ShoppingCartDto> findAll() {
        return ParseUtils.parse(shoppingCartRepository.findAll(), ShoppingCartDto.class);
    }

    @Override
    public void delete(Integer id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public ShoppingCartDto update(ShoppingCartDto dto) {
        return ParseUtils.parse(
                shoppingCartRepository.saveAndFlush(ParseUtils.parse(dto, ShoppingCart.class)),
                ShoppingCartDto.class);
    }
}
