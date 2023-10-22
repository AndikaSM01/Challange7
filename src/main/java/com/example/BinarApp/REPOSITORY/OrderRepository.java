package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.ENTITY.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
//    //@Query("SELECT z  FROM Order z INNER JOIN z.user u INNER JOIN z.orderDetails x WHERE u.userId = :userId")
//    List<Order> findOrderByUserId(@Param("userId") Long userId);
//    @Query("SELECT o FROM Order o WHERE o.user.id = :id")
//    List<Order> findOrderByUserId(@Param("id") Long id);
//
//    @Query("SELECT z  FROM Order z INNER JOIN z.user u INNER JOIN z.orderDetails uz")
//    List<Order> findOrderAll();
}
