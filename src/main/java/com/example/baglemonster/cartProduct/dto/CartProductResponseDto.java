package com.example.baglemonster.cartProduct.dto;

import com.example.baglemonster.cartProduct.entity.CartProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartProductResponseDto {
    private Long productId;
    private String name;
    private Integer price;
    private Integer quantity;

    public static CartProductResponseDto of(CartProduct cartProduct) {
        return CartProductResponseDto.builder()
                .productId(cartProduct.getProduct().getId())
                .name(cartProduct.getProduct().getName())
                .price(cartProduct.getProduct().getPrice())
                .quantity(cartProduct.getQuantity())
                .build();
    }
}
