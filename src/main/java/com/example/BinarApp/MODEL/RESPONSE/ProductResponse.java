package com.example.BinarApp.MODEL.RESPONSE;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String productName;
    private Double price;
    private String merchantName;
}
