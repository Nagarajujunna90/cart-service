package com.example.cartservice.dto;

import lombok.Data;

@Data
public class CartRequest {
    private String productId;
    private Integer customerId;
}
