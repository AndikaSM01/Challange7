package com.example.BinarApp.MODEL.RESPONSE;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class MerchantResponse {
    private Long id;
    private String MerchantName;
    private String Location;
    private String open;


    public MerchantResponse(String merchantTidakDitemukan) {
    }
}
