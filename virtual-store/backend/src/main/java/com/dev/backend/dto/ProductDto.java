package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDto extends AuditableDto {

    private Integer id;

    @NotEmpty(message = "{name.not.empty}")
    private String name;

    @NotEmpty(message = "{short.description.not.empty}")
    private String shortDescription;

    private String detailedDescription;

    @NotNull(message = "{brand.not.null}")
    private BrandDto brandDto;

    @NotEmpty(message = "{cost.value.not.empty}")
    private Double costValue;

    @NotEmpty(message = "{sale.value.not.empty}")
    private Double saleValue;

    private ImageDto imageDto;
}
