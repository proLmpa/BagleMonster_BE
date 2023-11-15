package com.example.baglemonster.cart.event;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.user.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderCancelEvent extends ApplicationEvent {
    private final Cart order;
    private final User customer;

    public OrderCancelEvent(Object source, Cart order, User customer) {
        super(source);
        this.order = order;
        this.customer = customer;
    }
}
