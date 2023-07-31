package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class CityDto extends AuditableDto {

    private Integer id;

    @NotEmpty(message = "{name.not.empty}")
    private String name;

    @NotNull(message = "{state.not.null}")
    private StateDto state;
}
