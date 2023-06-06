package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PeopleDto extends AuditableDto {

    private Integer id;

    private String name;

    private String cpf;

    private String email;

    private AddressDto addressDto;

    private Integer number;

    private List<PermissionDto> permissionDtos;
}
