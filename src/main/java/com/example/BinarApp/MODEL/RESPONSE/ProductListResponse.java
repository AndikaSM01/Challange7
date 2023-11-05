package com.example.BinarApp.MODEL.RESPONSE;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListResponse {
    private String productCode;
    private String productName;
    private Double price;
    private  String merchantName;


}
