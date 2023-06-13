package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImageDto extends AuditableDto {

    private Integer id;

    @URL
    @NotEmpty
    private String url;
}
