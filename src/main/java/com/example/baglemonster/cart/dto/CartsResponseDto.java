package com.example.baglemonster.cart.dto;

import com.example.baglemonster.cart.entity.Cart;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CartsResponseDto {
    private List<CartResponseDto> carts;
    public static CartsResponseDto of(List<Cart> carts) {
        List<CartResponseDto> cartsResponseDto = carts.stream().map(
                CartResponseDto::of).toList();

        return CartsResponseDto.builder()
                .carts(cartsResponseDto)
                .build();
    }
}
