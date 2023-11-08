//package com.example.baglemonster.order.dto;
//
//import com.example.baglemonster.order.entity.Order;
//import lombok.*;
//
//@Builder
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
//public class OrderResponseDto {
//    private Long id;
//    private Integer totalPrice;
//
////    private List<OrderProductsResponseDto> orderProducts;
//
//    public static OrderResponseDto of(Order order) {
//        return OrderResponseDto.builder()
//                .id(order.getId())
//                .totalPrice(order.getTotalPrice())
////                .orderProducts(order.getOrderProducts().stream().map(OrderProductsResponseDto::of).toList())
//                .build();
//    }
//}
