package com.example.BinarApp.CONTROLLER;

import com.example.BinarApp.MODEL.RESPONSE.OrderRequest;
import com.example.BinarApp.SERVICE.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Api/BinarFud/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<String>createOrder(@RequestBody OrderRequest orderRequest){
        String respon = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.OK).body(respon);
    }
}
