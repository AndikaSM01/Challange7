package com.example.BinarApp.MODEL;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GenericGenerator(strategy = "uuid2",name= "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    @Column(length = 30, nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 30, nullable = false)
    private String password;
}
