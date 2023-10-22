package com.example.BinarApp.CONTROLLER;

import com.example.BinarApp.ENTITY.Product;
import com.example.BinarApp.MODEL.RESPONSE.ProductResponse;
import com.example.BinarApp.SERVICE.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Api/BinarFud/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<String >addProduct(@RequestBody String inputProductName, String inputPrice, String inputmerchanCode){
        String respon = productService.addProduct(inputProductName,inputPrice,inputmerchanCode);
        return ResponseEntity.status(HttpStatus.OK).body(respon);
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product respon = productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(respon);
    }
    @DeleteMapping(path = "/{productid}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productid")Long id){
        productService.delleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Succes delete Product");
    }

}
