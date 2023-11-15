package com.example.baglemonster.cart.repository;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.cart.entity.StoreStatusEnum;
import com.example.baglemonster.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserAndStatus(User user, boolean status);

    List<Cart> findAllByUser(User user);

    List<Cart> findByStoreIdAndStatusAndStoreStatusIn(Long storeId, boolean b, List<StoreStatusEnum> neworder);
}
