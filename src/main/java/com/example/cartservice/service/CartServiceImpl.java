package com.example.cartservice.service;


import com.example.cartservice.config.ClientConfig;
import com.example.cartservice.model.Cart;
import com.example.cartservice.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private EventServiceLog eventServiceLog;


//    @Autowired
//    @Qualifier("singleThreadPool")
//    private ExecutorService executorService;

    public CartServiceImpl(CartRepository cartRepository, ClientConfig clientConfig) {
        this.cartRepository = cartRepository;
        this.clientConfig = clientConfig;
    }

    @Override
    public String addCart(Cart cart) {
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("productId", cart.getProductId());
        //   Mono<Product> product = clientConfig.getProductById("http://localhost:8084/product/v1/product/{productId}", pathParams, Product.class);
        // product.subscribe(value -> System.out.println(value));
//        if (cart.getCustomerId() != null) {
//            User user = userRepository.findById(cart.getCustomerId()).orElse(null);
//            cart.setUser(user);
//        }


        Cart cart1 = cartRepository.save(cart);
        eventServiceLog.addEvent(cart1, "PRODUCT_ADDED_TO_CART");
        return "Product added successfully";
    }

    @Override
    public List<Cart> findAllCartsById(Integer userId) {
        //  List<Product> productList=new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Cart> cartList = cartRepository.findCartsByUserId(userId);
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
        eventServiceLog.addEvent(cartList, "ALL_PRODUCTS_FETCHED_IN_CART");

        return cartList;
    }

    @Override
    public String deleteProductFromCart(String productId) {
        cartRepository.deleteByProductId(productId);
        eventServiceLog.addEvent(productId, "PRODUCT_DELETED_IN_CART");
        return "deleted successfully";
    }


//    public <T> Future<T> execute(Callable<T> callable) {
//        return executorService.submit(callable);
//    }
}
