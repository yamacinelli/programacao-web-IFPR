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

    @NotEmpty(message = "{name.not.empty}")
    private String name;

    @CPF(message = "{cpf.invalid}")
    @NotEmpty(message = "{cpf.not.empty}")
    private String cpf;

    @Email(message = "{email.invalid}")
    @NotEmpty(message = "{email.not.empty}")
    private String email;

    private AddressDto addressDto;

    private Integer number;

    @NotEmpty(message = "{permission.not.empty}")
    private List<PermissionDto> permissionDtos;
}
