package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
public class StateDto extends AuditableDto {

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Size(min = 2, max = 2)
    private String abbreviation;
}
