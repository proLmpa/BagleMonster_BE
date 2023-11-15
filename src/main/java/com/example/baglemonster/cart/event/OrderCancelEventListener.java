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
public class OrderCancelEventListener implements ApplicationListener<OrderCancelEvent> {
    private final NotificationService notificationService;

    @Override
    @TransactionalEventListener
    public void onApplicationEvent(OrderCancelEvent event) {
        Cart order = event.getOrder();
        String content = "'" + order.getStore().getName() + "' 주문이 취소되었습니다.";
        LocalDateTime createdAt = order.getModifiedDate();
        User customer = event.getCustomer();
        Notification notification = new Notification(content, createdAt, order, customer);
        notificationService.saveNotification(notification, customer.getId());
        log.info("주문 취소 이벤트 발생");
    }
}
