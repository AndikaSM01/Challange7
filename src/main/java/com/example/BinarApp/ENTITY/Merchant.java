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

//    @Id
//    @GenericGenerator(strategy = "uuid2", name = "uuid")
//    @GeneratedValue(generator = "uuid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "merchant_code")
    private String merchantCode;

    @Column(name = "merchant_name",  unique = true)
    private String merchantName;

    @Column(name = "merchant_location", unique = true)
    private String merchantLocation;

    private Boolean open;


}
