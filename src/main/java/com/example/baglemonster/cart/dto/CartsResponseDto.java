package com.example.baglemonster.cart.dto;

import com.example.baglemonster.cart.entity.Cart;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CartsResponseDto {
    private List<CartResponseDto> products;
    public static CartsResponseDto of(List<Cart> products) {
        List<CartResponseDto> productsResponseDto = products.stream().map(
                CartResponseDto::of).toList();

        return CartsResponseDto.builder()
                .products(productsResponseDto)
                .build();
    }
}
