package com.dev.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ShoppingCart extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date purchaseDate;

    private String note;

    private String situation;

    @ManyToMany
    private List<Product> products;

    private Double amount;

    private Integer quantity;
}
