package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CityDto extends AuditableDto {

    private Integer id;

    private String name;

    private StateDto stateDto;
}
