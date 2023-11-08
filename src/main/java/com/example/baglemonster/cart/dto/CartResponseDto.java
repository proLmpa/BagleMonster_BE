package com.example.baglemonster.cart.dto;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.cartProduct.dto.CartProductResponseDto;
import com.example.baglemonster.cartProduct.entity.CartProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
    private Long cartId;
    private String storeName;
    private List<CartProductResponseDto> products;
    private Integer totalPrice;
    private String request;

    public static CartResponseDto of(Cart cart) {
        List<CartProduct> cartProducts = cart.getCartProducts();
        return CartResponseDto.builder()
                .cartId(cart.getId())
                .storeName(cart.getStore().getName())
                .products(cartProducts.stream().map(CartProductResponseDto::of).toList())
                .totalPrice(cart.getTotalPrice())
                .request(cart.getRequest())
                .build();
    }
}