package com.example.BinarApp.MODEL.RESPONSE;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class OrderResponse {
    private Date  orderTime;
    private String complete;
    private String userName;
    private String adress;
    private OrderDetailResponsees orderDetailResponsees;



}
