package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressDto extends AuditableDto {

    private Integer id;

    @NotEmpty(message = "{street.not.empty}")
    private String street;

    @NotEmpty(message = "{district.not.empty}")
    private String district;

    @NotEmpty(message = "{cep.not.empty}")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "{cep.pattern}")
    private String cep;

    @NotNull(message = "{city.not.null}")
    private CityDto cityDto;
}
