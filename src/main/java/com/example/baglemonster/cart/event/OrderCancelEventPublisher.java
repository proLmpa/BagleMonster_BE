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
public class OrderCancelEventPublisher {
    public final ApplicationEventPublisher eventPublisher;

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void publishCartOrderEvent(Cart order, User customer) {
        OrderCancelEvent event = new OrderCancelEvent(this, order, customer);
        eventPublisher.publishEvent(event);
        log.info("주문 취소 이벤트 생성");
    }
}
