package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.ENTITY.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
