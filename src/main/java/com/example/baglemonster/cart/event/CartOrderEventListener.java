package com.example.baglemonster.cart.event;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.notification.entity.Notification;
import com.example.baglemonster.notification.service.NotificationService;
import com.example.baglemonster.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

@Slf4j(topic = "Event Listener")
@Component
@RequiredArgsConstructor
public class CartOrderEventListener implements ApplicationListener<CartOrderEvent> {
    private final NotificationService notificationService;

    @Override
    @TransactionalEventListener
    public void onApplicationEvent(CartOrderEvent event) {
        Cart cart = event.getCart();
        String content = "새로운 주문이 들어왔습니다!";
        LocalDateTime createdAt = cart.getModifiedDate();
        User storeUser = event.getStoreUser();
        Notification notification = new Notification(content, createdAt, cart, storeUser);
        notificationService.saveNotification(notification, storeUser.getId());
        log.info("주문 완료 이벤트 발생");
    }
}
