package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
public class CityDto extends AuditableDto {

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private StateDto stateDto;
}
