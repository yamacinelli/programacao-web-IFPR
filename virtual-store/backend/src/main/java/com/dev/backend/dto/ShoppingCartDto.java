package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShoppingCartDto extends AuditableDto {

    private Integer id;

    private Date purchaseDate;

    private String note;

    @NotEmpty
    @Size(min = 1, max = 2)
    private String situation;

    private List<ProductDto> productDtos;

    private Double amount;

    private Integer quantity;

    @NotEmpty
    private PeopleDto peopleDto;
}
