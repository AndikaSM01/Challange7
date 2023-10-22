package com.example.BinarApp.ENTITY;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;

    private Integer quantity;

    private Double totalPrice;

 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order ;

 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_code")
    private  Product product;

}
