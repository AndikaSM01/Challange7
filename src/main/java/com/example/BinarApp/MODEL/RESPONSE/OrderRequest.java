package com.example.BinarApp.MODEL.RESPONSE;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private Long userId;

    private String destinationAddress;

    private List<OrderItemDTO> orderItem;
}
