package com.dev.backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PeopleDto extends AuditableDto {

    private Integer id;

    @NotEmpty
    private String name;

    @CPF
    @NotEmpty
    private String cpf;

    @Email
    @NotEmpty
    private String email;

    private AddressDto addressDto;

    private Integer number;

    @NotEmpty
    private List<PermissionDto> permissionDtos;
}
