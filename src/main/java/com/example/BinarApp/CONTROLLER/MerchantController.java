package com.example.BinarApp.CONTROLLER;


import com.example.BinarApp.MODEL.REQUEST.MerchantRequest;
import com.example.BinarApp.MODEL.RESPONSE.MerchantResponse;
import com.example.BinarApp.SERVICE.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api/BinarFud/Merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;
    @PostMapping
    public ResponseEntity<MerchantResponse> addMerchant (@RequestBody MerchantRequest merchantRequest){
     MerchantResponse Respon = merchantService.addMerchant(merchantRequest);
     if(Respon == null ){

         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Respon);
     }
     return ResponseEntity.status(HttpStatus.OK).body(Respon);
    }

}
