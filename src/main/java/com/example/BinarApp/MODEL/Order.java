package com.example.BinarApp.MODEL;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Order {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "order_time")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm")
    private Date orderTime;

    @Column(name = "destination_address")
    private String destinationAddress;

    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;
}
