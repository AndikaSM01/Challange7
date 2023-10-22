package com.example.BinarApp.ENTITY;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product {

@Id
@GenericGenerator(strategy = "uuid2", name = "uuid")
@GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "product_code")
    private Long ProductCode;

    private String productName;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;}
