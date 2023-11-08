//package com.example.baglemonster.order.dto;
//
//import com.example.baglemonster.order.entity.Order;
//import com.example.baglemonster.store.entity.Store;
//import com.example.baglemonster.user.entity.User;
//import lombok.Getter;
//
//@Getter
//public class createOrderRequestDto {
//    private Long storeId;
//
//    public Order toEntity(User user, Store store) {
//        return Order.builder()
//                .user(user)
//                .store(store)
//                .build();
//    }
//}
