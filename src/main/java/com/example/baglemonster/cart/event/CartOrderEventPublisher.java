package com.example.baglemonster.cart.event;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j(topic = "Event Publisher")
@Component
@EnableAsync
@RequiredArgsConstructor
public class CartOrderEventPublisher {
    public final ApplicationEventPublisher eventPublisher;

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void publishCartOrderEvent(Cart cart, User storeUser) {
        CartOrderEvent event = new CartOrderEvent(this, cart, storeUser);
        eventPublisher.publishEvent(event);
        log.info("주문 완료 이벤트 생성");
    }
}
