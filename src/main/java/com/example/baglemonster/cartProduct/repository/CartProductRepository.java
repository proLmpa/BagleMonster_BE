package com.example.baglemonster.cartProduct.repository;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.cartProduct.entity.CartProduct;
import com.example.baglemonster.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    Optional<CartProduct> findByCartAndProduct(Cart cart, Product product);
}
