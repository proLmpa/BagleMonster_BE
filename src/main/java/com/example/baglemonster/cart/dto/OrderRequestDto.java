package com.example.baglemonster.cart.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderRequestDto {
    private List<CartRequestDto> productList;
    private Integer totalPrice;
}
