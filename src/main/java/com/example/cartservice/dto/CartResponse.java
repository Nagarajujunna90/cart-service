package com.example.cartservice.dto;

import com.example.cartservice.model.Cart;
import lombok.Data;

@Data
public class CartResponse {
    private String productId;
    private Integer cartId;

    public CartResponse(Cart cart) {
        this.cartId =cart.getUserId();
        this.productId=cart.getProductId();
    }
}
