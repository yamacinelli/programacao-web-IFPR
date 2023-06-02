package com.dev.backend.service;

import com.dev.backend.model.Address;
import com.dev.backend.repository.AddressRepository;
import com.dev.backend.model.GenericModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements GenericModel<Address> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address model) {
        return addressRepository.saveAndFlush(model);
    }

    @Override
    public List<Address> saveAll(List<Address> models) {
        return addressRepository.saveAllAndFlush(models);
    }

    @Override
    public Address findById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address update(Address model) {
        return addressRepository.saveAndFlush(model);
    }
}
