package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDto extends AuditableDto {

    private Integer id;

    private String name;

    private String shortDescription;

    private String detailedDescription;

    private BrandDto brandDto;

    private Double costValue;

    private Double saleValue;

    private ImageDto imageDto;
}
