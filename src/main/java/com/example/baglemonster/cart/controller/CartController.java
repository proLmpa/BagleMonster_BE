package com.example.baglemonster.cart.controller;

import com.example.baglemonster.cart.dto.CartRequestDto;
import com.example.baglemonster.cart.dto.CartResponseDto;
import com.example.baglemonster.cart.dto.CartsResponseDto;
import com.example.baglemonster.cart.dto.OrderRequestDto;
import com.example.baglemonster.cart.service.CartService;
import com.example.baglemonster.common.dto.ApiResponseDto;
import com.example.baglemonster.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "장바구니 API", description = "장바구니의 동작과 관련된 API 정보를 담고 있습니다.")
public class CartController {
    private final CartService cartService;

    @Operation(summary = "장바구니 메뉴 추가")
    @PostMapping("/carts")
    public ResponseEntity<ApiResponseDto> createCart(@RequestBody CartRequestDto cartRequestDto,
                                                     @AuthenticationPrincipal UserDetailsImpl userDetails) {
        cartService.createCart(cartRequestDto, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "상품이 장바구니에 추가되었습니다."));
    }

    @Operation(summary = "장바구니 조회")
    @GetMapping("/carts")
    public ResponseEntity<CartResponseDto> selectCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        CartResponseDto result = cartService.selectCart(userDetails.getUser());
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "특정 주문 취소")
    @DeleteMapping("/carts/{cartId}/products/{productId}")
    public ResponseEntity<ApiResponseDto> deleteCartProduct(@PathVariable Long cartId, @PathVariable Long productId,
                                                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        cartService.deleteCartProduct(cartId, productId, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.NO_CONTENT.value(), "장바구니에서 해당 상품을 제거했습니다."));
    }

    @Operation(summary = "전체 주문 취소")
    @DeleteMapping("/carts/{cartId}")
    public ResponseEntity<ApiResponseDto> deleteCart(@PathVariable Long cartId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        cartService.deleteCart(cartId, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.NO_CONTENT.value(), "장바구니에서 전체 상품을 제거했습니다."));
    }

    @Operation(summary = "장바구니 주문 완료")
    @PutMapping("/carts/{cartId}")
    public ResponseEntity<ApiResponseDto> orderCart(@PathVariable Long cartId, @RequestBody OrderRequestDto orderRequestDto,
                                                    @AuthenticationPrincipal UserDetailsImpl userDetails) {
        cartService.orderCart(cartId, orderRequestDto, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "장바구니의 상품들을 주문하였습니다."));
    }

    @Operation(summary = "주문 내역 조회")
    @GetMapping("/carts/history")
    public ResponseEntity<CartsResponseDto> selectCarts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        CartsResponseDto result = cartService.selectCarts(userDetails.getUser());
        return ResponseEntity.ok().body(result);
    }
}
