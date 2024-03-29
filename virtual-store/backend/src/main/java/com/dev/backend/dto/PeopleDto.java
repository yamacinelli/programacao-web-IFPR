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

    @CPF(message = "{cpf}")
    @NotEmpty(message = "{cpf.not.empty}")
    private String cpf;

    @Email(message = "{email}")
    @NotEmpty(message = "{email.not.empty}")
    private String email;

    private AddressDto address;

    private Integer number;

    @NotEmpty(message = "{permission.not.empty}")
    private List<PermissionDto> permission;
}
