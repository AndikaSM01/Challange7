package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.Merchant;
import com.example.BinarApp.MODEL.RESPONSE.MerchantResponse;

import java.util.List;

public interface MerchantService {
    MerchantResponse addMerchant (Merchant merchant);
    MerchantResponse updateMerchant (Merchant merchant);
    List<MerchantResponse> ShowMerchantStatusOPen();
}
