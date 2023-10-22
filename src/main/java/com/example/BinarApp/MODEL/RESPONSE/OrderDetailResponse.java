package com.example.BinarApp.MODEL.RESPONSE;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private Long id;
    private  Integer quantity;
    private Double totalPrice;
}
