package com.example.baglemonster.cart.dto;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderRequestDto {
    private String request;
}
