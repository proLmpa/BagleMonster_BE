package com.example.baglemonster.cart.dto;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.cartProduct.entity.CartProduct;
import com.example.baglemonster.product.entity.Product;
import com.example.baglemonster.store.entity.Store;
import com.example.baglemonster.user.entity.User;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CartRequestDto {

    private Long storeId;
    private Long productId;
    private Integer quantity;

    public Cart toCart(User user, Store store) {
        return Cart.builder()
                .status(false)
                .user(user)
                .store(store)
                .build();
    }

    public CartProduct toEntityCartProduct(Cart cart, Product product) {
        return CartProduct.builder()
                .cart(cart)
                .product(product)
                .quantity(this.quantity)
                .build();
    }
}
