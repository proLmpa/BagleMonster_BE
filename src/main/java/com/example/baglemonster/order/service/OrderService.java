package com.example.baglemonster.order.service;

import com.example.baglemonster.order.dto.updateOrderRequestDto;
import com.example.baglemonster.order.repository.OrderRepository;
import com.example.baglemonster.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void createOrder(User user, Long storeId) {
        // user와 store 존재 여부 확인 후 order 생성
    }

//    @Transactional(readOnly = true)
//    public OrderResponseDto getOrder(User user, Long orderId) {
//        // user의 존재 여부와 그를 토대로 order 검색 후 return
//
//        return new OrderResponseDto();
//    }

    @Transactional
    public void updateOrder(User user, Long orderId, updateOrderRequestDto updateOrderRequestDto) {
        // user의 존재 여부와 그를 토대로 order 검색

        // order 내부의 product 존재 여부 확인 후 수량 조절
    }

    @Transactional
    public void deleteOrder(User user, Long orderId, Long productId) {
        // user의 존재 여부와 그를 토대로 order 검색

        // order 내부의 product 존재 여부 확인 후 해당 상품 삭제

    }

    @Transactional
    public void deleteOrders(User user, Long orderId) {
        // user의 존재 여부와 그를 토대로 order 검색

        // order 전체 삭제
    }

    @Transactional
    public void completeOrder(User user, Long orderId) {
        // user의 존재 여부와 그를 토대로 order 검색

        // order의 상태를 true(주문 완료)로 변경
    }
}
