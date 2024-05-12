package com.swiftcart.cartservice.repository;

import com.swiftcart.cartservice.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT * FROM Cart c WHERE c.u_id=:userId", nativeQuery = true)
    List<Cart> findByUserId(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM Cart c WHERE c.u_id=:userId AND c.p_id=:productId", nativeQuery = true)
    Cart findByUserIdAndPId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    @Query(value = "SELECT * FROM Cart c WHERE c.u_id=:userId AND c.product_id=:productId", nativeQuery = true)
    Cart findByUserIdAndProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);
}
