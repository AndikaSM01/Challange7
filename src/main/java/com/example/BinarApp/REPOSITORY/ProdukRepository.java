package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.ENTITY.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdukRepository extends JpaRepository<Product,String> {


    //@Query("SELECT p FROM Product p INNER JOIN p.merchant m ORDER BY p.addedTime ASC")
    Page<Product> findAll(Pageable pageable);
//    @Query(nativeQuery = true, value = "select * from movie")
//    Page<Product> findAllWithPaging(Pageable pageable);
    static boolean existsByProductName(String inputProductName) {
        return false;
    }

    static boolean existsByPrice(String inputPrice) {
        return false;
    }
}
