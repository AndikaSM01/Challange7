package com.example.BinarApp.SERVICE;

import com.example.BinarApp.MODEL.REQUEST.OrderRequest;
import com.example.BinarApp.MODEL.RESPONSE.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
}
