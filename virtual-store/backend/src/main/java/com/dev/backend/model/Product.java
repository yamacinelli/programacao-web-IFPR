package com.dev.backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Product extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Lob
    private String shortDescription;

    @Lob
    private String detailedDescription;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    private Double costValue;

    private Double saleValue;

    @OneToOne
    private Image image;
}
