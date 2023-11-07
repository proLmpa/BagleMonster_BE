package com.example.baglemonster.order.controller;

import com.example.baglemonster.common.dto.ApiResponseDto;
import com.example.baglemonster.order.dto.createOrderRequestDto;
import com.example.baglemonster.order.dto.updateOrderRequestDto;
import com.example.baglemonster.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "주문")
public class OrderController {

    @Operation(summary = "주문 생성")
    @PostMapping
    public ResponseEntity<ApiResponseDto> createOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody createOrderRequestDto createOrderRequestDto) {
        orderService.createOrder(userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "주문이 생성되었습니다."));
    }

    @Operation(summary = "주문 조회")
    @GetMapping("/{orderId")
    public ResponseEntity<OrderResponseDto> getOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long orderId) {
        return orderService.getOrder(userDetails.getUser(), orderId);
    }

    @Operation(summary = "주문 수정")
    @PutMapping("/{orderId}")
    public ResponseEntity<ApiResponseDto> updateOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long orderId, @RequestBody updateOrderRequestDto updateOrderRequestDto) {
        orderService.updateOrder(userDetails.getUser(), orderId, updateOrderRequestDto);
        return ResponseEntity.ok(new ApiResponseDto(HttpStatus.OK.value(), "장바구니의 상품을 수정했습니다."));
    }

    @Operation(summary = "특정 주문 상품 취소")
    @DeleteMapping("/{orderId}/products/{productId}")
    public ResponseEntity<ApiResponseDto> deleteOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long orderId, @PathVariable Long productId) {
        orderService.deleteOrder(userDetails.getUser(), orderId, productId);
        return ResponseEntity.ok(new ApiResponseDto(HttpStatus.OK.value(), "장바구니에서 전체 상품을 제거했습니다."));
    }

    @Operation(summary = "전체 주문 상품 취소")
    @DeleteMapping("/{orderId}")
    public ResponseEntity<ApiResponseDto> deleteOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long orderId) {
        orderService.deleteOrder(userDetails.getUser(), orderId);
        return ResponseEntity.ok(new ApiResponseDto(HttpStatus.OK.value(), "장바구니에서 전체 상품을 제거했습니다."));
    }

    @Operation(summary = "주문하기")
    @PostMapping("/{orderId}")
    public ResponseEntity<ApiResponseDto> completeOrder(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long orderId) {
        orderService.completeOrder(userDetails.getUser(), orderId);
        return ResponseEntity.ok(new ApiResponseDto(HttpStatus.OK.value(), "장바구니의 상품들을 주문했습니다."));
    }
}
