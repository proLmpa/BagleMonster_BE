package com.example.baglemonster.cart.service;

import com.example.baglemonster.cart.dto.OrderResponseDto;
import com.example.baglemonster.cart.dto.OrdersResponseDto;
import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.cart.entity.StoreStatusEnum;
import com.example.baglemonster.cart.repository.CartRepository;
import com.example.baglemonster.cartProduct.entity.CartProduct;
import com.example.baglemonster.common.exception.NotFoundException;
import com.example.baglemonster.common.exception.UnauthorizedException;
import com.example.baglemonster.store.entity.Store;
import com.example.baglemonster.store.repository.StoreRepository;
import com.example.baglemonster.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CartRepository cartRepository;
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public OrdersResponseDto selectOrders(User user, Long storeId) {
        confirmStore(user, storeId);

        return OrdersResponseDto.of(getOrders(storeId));
    }

    @Transactional
    public OrderResponseDto selectOrder(User user, Long storeId, Long orderId) {
        confirmStore(user, storeId);

        Cart order = getOrder(orderId);
        if (order.getStoreStatus().equals(StoreStatusEnum.NEWORDER)) {
            order.editStoreStatus(StoreStatusEnum.READ);
        }

        return OrderResponseDto.of(getOrder(orderId));
    }

    @Transactional
    public void completeOrder(User user, Long storeId, Long orderId) {
        confirmStore(user, storeId);
        Cart order = getOrder(orderId);
        order.editStoreStatus(StoreStatusEnum.SOLD);

        List<CartProduct> cartProducts = order.getCartProducts();
        for (CartProduct cartProduct : cartProducts) {
            cartProduct.getProduct().addPopularity(cartProduct.getQuantity());
        }
    }

    @Transactional
    public void cancelOrder(User user, Long storeId, Long orderId) {
        confirmStore(user, storeId);
        Cart order = getOrder(orderId);
        order.editStoreStatus(StoreStatusEnum.CANCELED);
    }

    private void confirmStore(User user, Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(() ->
                new NotFoundException("선택한 가게는 존재하지 않습니다."));

        if (!store.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("해당 가게에 대한 권한이 없습니다.");
        }
    }

    private List<Cart> getOrders(Long storeId) {
        return cartRepository.findByStoreIdAndStatusAndStoreStatusIn(storeId, true, List.of(StoreStatusEnum.NEWORDER, StoreStatusEnum.READ));
    }

    private Cart getOrder(Long orderId) {
        return cartRepository.findById(orderId).orElseThrow(() ->
                new NotFoundException("선택한 주문은 존재하지 않습니다."));
    }
}
