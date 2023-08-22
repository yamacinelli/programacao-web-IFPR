package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShoppingCartDto extends AuditableDto {

    private Integer id;

    private Date purchaseDate;

    private String note;

    @NotEmpty(message = "{situation.not.empty}")
    @Size(min = 1, max = 2, message = "{situation.size}")
    private String situation;

    private List<ProductDto> productsDto;

    private Double amount;

    private Integer quantity;

    @NotNull(message = "{people.not.null}")
    private PeopleDto peopleDto;
}
