package com.ecommerce.swiftcart.repository;

import com.ecommerce.swiftcart.models.Cart;
import com.ecommerce.swiftcart.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT * FROM Cart c WHERE c.user_id=:userId", nativeQuery = true)
    List<Cart> findByUserId(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM Cart c WHERE c.user_id=:userId AND c.product_id=:productId", nativeQuery = true)
    Cart findByUserIdAndProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);
}
