package com.example.BinarApp.MODEL.RESPONSE;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderResponses { private Long id;
 private LocalDateTime orderTime;
 private String destinationAdress;
 private String completed;
 private String BuyerName;
 private List<OrderDetailResponse>detailOrder;


}
