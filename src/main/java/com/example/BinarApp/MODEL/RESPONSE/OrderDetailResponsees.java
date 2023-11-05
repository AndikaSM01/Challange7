package com.example.BinarApp.MODEL.RESPONSE;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDetailResponsees {
    private Integer quantity;
    private Double totalPrice;
    private List<ProductListResponse> productListResponses;



}
