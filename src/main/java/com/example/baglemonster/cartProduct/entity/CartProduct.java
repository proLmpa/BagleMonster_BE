package com.example.baglemonster.cartProduct.entity;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.common.entity.Timestamped;
import com.example.baglemonster.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name="cartProducts")
public class CartProduct extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cartId", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private Product product;
    private Integer quantity;

    public void subtractCartProductQuantity() {
        this.quantity = getQuantity() - 1;
    }

    public void addCartProductQuantity() {
        this.quantity = getQuantity() + 1;
    }
}

