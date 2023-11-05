package com.example.BinarApp.CONTROLLER;

import com.example.BinarApp.MODEL.REQUEST.OrderRequest;
import com.example.BinarApp.MODEL.RESPONSE.OrderResponse;
import com.example.BinarApp.SERVICE.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Api/BinarFud/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<OrderResponse>createOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse respon = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.OK).body(respon);
    }

}
