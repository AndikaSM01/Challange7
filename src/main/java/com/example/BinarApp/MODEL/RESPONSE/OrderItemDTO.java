package com.example.BinarApp.MODEL.RESPONSE;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDTO {
    private Long productId;
    private int quantity;
}
