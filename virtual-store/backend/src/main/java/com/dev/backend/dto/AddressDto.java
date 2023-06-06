package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressDto extends AuditableDto {

    private Integer id;

    private String street;

    private String district;

    private String cep;

    private CityDto cityDto;
}
