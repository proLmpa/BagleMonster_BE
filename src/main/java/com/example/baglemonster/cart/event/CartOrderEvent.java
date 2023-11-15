package com.example.baglemonster.cart.event;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.user.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CartOrderEvent extends ApplicationEvent {
    private final Cart cart;
    private final User storeUser;

    public CartOrderEvent(Object source, Cart cart, User storeUser) {
        super(source);
        this.cart = cart;
        this.storeUser = storeUser;
    }
}
