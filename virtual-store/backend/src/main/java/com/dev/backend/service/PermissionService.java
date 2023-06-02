package com.dev.backend.service;

import com.dev.backend.model.Permission;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService implements GenericModel<Permission> {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission save(Permission model) {
        return permissionRepository.saveAndFlush(model);
    }

    @Override
    public List<Permission> saveAll(List<Permission> models) {
        return permissionRepository.saveAllAndFlush(models);
    }

    @Override
    public Permission findById(Integer id) {
        return permissionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public Permission update(Permission model) {
        return permissionRepository.saveAndFlush(model);
    }
}
