package com.dev.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class People extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    @ManyToOne
    private Address address;

    private Integer number;

    @ManyToMany
    private List<Permission> permission;

    /**
     * Constructor to return specifics columns in criteria query
     * @param id Integer
     * @param name String
     * @param cpf String
     * @param email String
     */
    public People(Integer id, String name, String cpf, String email) {
        this.setId(id);
        this.setName(name);
        this.setCpf(cpf);
        this.setEmail(email);
    }
}
