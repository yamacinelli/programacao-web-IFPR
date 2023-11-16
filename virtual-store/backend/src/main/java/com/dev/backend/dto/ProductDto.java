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
    private BrandDto brand;

    @NotNull(message = "{category.not.null}")
    private CategoryDto category;

    @NotNull(message = "{cost.value.not.null}")
    private Double costValue;

    private Double saleValue;

    private ImageDto image;
}
