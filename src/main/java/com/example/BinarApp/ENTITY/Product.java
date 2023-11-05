package com.example.BinarApp.ENTITY;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String  id;

    @Column(name = "product_code", length = 5, nullable = false, unique = true)
    private String productCode;

    @Column(name = "product_name", length = 30, nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false, referencedColumnName = "id")
    private Merchant merchant;
}
