package com.example.baglemonster.cart.entity;

import com.example.baglemonster.cart.dto.OrderRequestDto;
import com.example.baglemonster.cartProduct.entity.CartProduct;
import com.example.baglemonster.common.entity.Timestamped;
import com.example.baglemonster.store.entity.Store;
import com.example.baglemonster.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "carts")
public class Cart extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "totalPrice", nullable = false)
    private Integer totalPrice;

    @Column(name = "request")
    private String request;

    // 장바구니 상태면 false, 주문 완료 상태면 true
    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    @Builder.Default
    @OneToMany(mappedBy = "cart", orphanRemoval = true)
    private List<CartProduct> cartProducts = new ArrayList<>();

    public void editTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void order(OrderRequestDto orderRequestDto) {
        this.request = orderRequestDto.getRequest();
        this.status = true;
    }
}
