package com.example.cartservice.service;


import com.example.cartservice.model.Cart;

import java.util.List;

public interface CartService {
    Cart addCart(Cart cart);

    List<Cart> findAllCartsById(Integer userId);


    String deleteProductFromCart(String productId);
}
