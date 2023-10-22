package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.Order;
import com.example.BinarApp.ENTITY.OrderDetail;
import com.example.BinarApp.ENTITY.User;
import com.example.BinarApp.MODEL.RESPONSE.OrderRequest;
import com.example.BinarApp.MODEL.RESPONSE.OrderResponses;

import java.util.List;

public interface OrderService {
    String createOrder(OrderRequest orderRequest);
}
