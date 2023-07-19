package com.example.cartservice.service;


import com.example.cartservice.config.ClientConfig;
import com.example.cartservice.model.Cart;
import com.example.cartservice.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ClientConfig clientConfig;


//    @Autowired
//    @Qualifier("singleThreadPool")
//    private ExecutorService executorService;

    public CartServiceImpl(CartRepository cartRepository, ClientConfig clientConfig) {
        this.cartRepository = cartRepository;
        this.clientConfig = clientConfig;
    }

    @Override
    public Cart addCart(Cart cart) {
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("productId", cart.getProductId());
     //   Mono<Product> product = clientConfig.getProductById("http://localhost:8084/product/v1/product/{productId}", pathParams, Product.class);
       // product.subscribe(value -> System.out.println(value));
//        if (cart.getCustomerId() != null) {
//            User user = userRepository.findById(cart.getCustomerId()).orElse(null);
//            cart.setUser(user);
//        }

        return cartRepository.save(cart);

        //return cart;
    }

    @Override
    public List<Cart> findAllCartsById(Integer userId) {
      //  List<Product> productList=new ArrayList<>();
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        List<Cart> cartList=new ArrayList<>();
        //= cartRepository.findCartsByUserId(userId);
//        for (Cart cart : Cart) {
//            Map<String, Object> pathParams = new HashMap<>();
//            pathParams.put("productId", cart.getProductId());
//            CompletableFuture.supplyAsync(() -> {
//                return clientConfig.getProductById("http://localhost:8084/product/v1/product/{productId}", pathParams, Product.class);
//            }).thenCompose(productMono -> {
//                productMono.subscribe(value -> {
//                    System.out.println(value);
//                    productList.add(value);
//                });
//                return null;
//            });
//        return Cart;
//        }
        return cartList;
    }

    @Override
    public String deleteProductFromCart(String productId) {
       // cartRepository.deleteByProductId(productId);
        return "deleted successfully";
    }


//    public <T> Future<T> execute(Callable<T> callable) {
//        return executorService.submit(callable);
//    }
}
