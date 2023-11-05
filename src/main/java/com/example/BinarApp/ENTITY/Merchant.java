package com.example.BinarApp.ENTITY;

import com.example.BinarApp.MODEL.RESPONSE.MerchantResponse;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "merchant_code", length = 5, nullable = false, unique = true)
    private String merchantCode;

    @Column(name = "merchant_name", length = 30, nullable = false, unique = true)
    private String merchantName;

    @Column(name = "merchant_location", length = 100, nullable = false, unique = true)
    private String merchantLocation;

    private Boolean open;


}
