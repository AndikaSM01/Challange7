package com.example.BinarApp.MODEL;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_name", length = 30, nullable = false, unique = true)
    private String merchantName;

    @Column(name = "merchant_location", length = 100, nullable = false, unique = true)
    private String merchantLocation;

    @Column(name = "merchant_code", length = 5, nullable = false, unique = true)
    private String merchantCode;

    private Boolean open;
}
