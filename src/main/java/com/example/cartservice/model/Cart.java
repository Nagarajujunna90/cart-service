package com.example.cartservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart_tbl")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productId;
    private Integer userId;

}
