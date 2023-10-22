package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
String addProduct( String inputProductName , String inputPrice , String merchantCode );
Product updateProduct(Product product);
void delleteProduct(Long product);

    Page<Product> getProductPaged(int page);
}
