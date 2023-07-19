package com.example.cartservice.dto;

import com.example.cartservice.model.Cart;
import lombok.Data;

@Data
public class CartResponse {
    private String productId;
    private Integer customerId;

    public CartResponse(Cart cart) {
        this.customerId=cart.getCustomerId();
        this.productId=cart.getProductId();
    }
}
