package com.example.baglemonster.cart.dto;

import com.example.baglemonster.cart.entity.Cart;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrdersResponseDto {

    private List<OrderResponseDto> orders;

    public static OrdersResponseDto of(List<Cart> carts) {
        List<OrderResponseDto> ordersResponseDto = carts.stream()
                .map(OrderResponseDto::of).toList();

        return OrdersResponseDto.builder()
                .orders(ordersResponseDto)
                .build();
    }
}
