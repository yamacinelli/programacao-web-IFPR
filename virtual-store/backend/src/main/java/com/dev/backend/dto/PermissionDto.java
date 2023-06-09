package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionDto extends AuditableDto {

    private Integer id;

    @NotEmpty(message = "{name.not.empty}")
    private String name;
}
