package com.example.baglemonster.cart.dto;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.cartProduct.dto.CartProductResponseDto;
import com.example.baglemonster.cartProduct.entity.CartProduct;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class OrderResponseDto {

    private Long orderId;
    private String storeName;
    private List<CartProductResponseDto> products;
    private Integer totalPrice;
    private String request;
    private String storeStatus;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static OrderResponseDto of(Cart cart) {
        List<CartProduct> cartProducts = cart.getCartProducts();
        return OrderResponseDto.builder()
                .orderId(cart.getId())
                .storeName(cart.getStore().getName())
                .products(cartProducts.stream().map(CartProductResponseDto::of).toList())
                .totalPrice(cart.getTotalPrice())
                .request(cart.getRequest())
                .storeStatus(cart.getStoreStatus().getStatus())
                .createdDate(cart.getCreatedDate())
                .modifiedDate(cart.getModifiedDate())
                .build();
    }
}
