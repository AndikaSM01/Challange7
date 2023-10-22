package com.example.BinarApp.ENTITY;
import com.example.BinarApp.MODEL.RESPONSE.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name ="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "order_id")
    private Long id;

    private Date orderTime;

    private String destinationAddress;
    @Enumerated(EnumType.STRING)
    private OrderStatus completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList;
}
