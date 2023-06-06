package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StateDto extends AuditableDto {

    private Integer id;

    private String name;

    private String abbreviation;
}
