package com.webapp.Blossom.models;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name= "products")
@ToString @EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Long id;

    @Getter @Setter @Column(name="name")
    private String name;

    @Getter @Setter @Column(name="description")
    private String description;

    @Getter @Setter @Column(name="price")
    private Double price;

    @Getter @Setter @Column(name="quantity")
    private Integer quantity;
}
