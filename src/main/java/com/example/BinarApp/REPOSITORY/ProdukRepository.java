package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.MODEL.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdukRepository extends JpaRepository<Product,String> {

}
