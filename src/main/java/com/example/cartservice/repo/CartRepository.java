package com.example.cartservice.repo;


import com.example.cartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
//    @Query("select c from Cart c where c.user.id=:userId")
//    List<Cart> findCartsByUserId(@Param("userId") Integer userId);
//
//    @Transactional
//    void deleteByProductId(String productId);
}
