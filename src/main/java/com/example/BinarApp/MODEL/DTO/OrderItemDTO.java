package com.example.BinarApp.MODEL.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDTO {
    private String productId;
    private int quantity;
}
