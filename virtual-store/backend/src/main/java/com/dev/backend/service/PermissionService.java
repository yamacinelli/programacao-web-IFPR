package com.dev.backend.service;

import com.dev.backend.dto.PermissionDto;
import com.dev.backend.model.Permission;
import com.dev.backend.model.GenericModel;
import com.dev.backend.repository.PermissionRepository;
import com.dev.backend.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService implements GenericModel<PermissionDto> {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public PermissionDto save(PermissionDto dto) {
        return ParseUtils.parse(
                permissionRepository.saveAndFlush(ParseUtils.parse(dto, Permission.class)),
                PermissionDto.class);
    }

    @Override
    public List<PermissionDto> saveAll(List<PermissionDto> dtos) {
        return ParseUtils.parse(
                permissionRepository.saveAllAndFlush(ParseUtils.parse(dtos, Permission.class)),
                PermissionDto.class);
    }

    @Override
    public PermissionDto findById(Integer id) {
        return ParseUtils.parse(permissionRepository.findById(id).orElse(null), PermissionDto.class);
    }

    @Override
    public List<PermissionDto> findAll() {
        return ParseUtils.parse(permissionRepository.findAll(), PermissionDto.class);
    }

    @Override
    public void delete(Integer id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public PermissionDto update(PermissionDto dto) {
        return ParseUtils.parse(
                permissionRepository.saveAndFlush(ParseUtils.parse(dto, Permission.class)),
                PermissionDto.class);
    }
}
