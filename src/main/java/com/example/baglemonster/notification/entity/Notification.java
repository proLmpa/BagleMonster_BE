package com.example.baglemonster.notification.entity;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "createdDate", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "rd", nullable = false)
    private Boolean rd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime expirationTime;

    public Notification(String content, LocalDateTime createdDate, Cart cart, User user) {
        this.cart = cart;
        this.user = user;
        this.content = content;
        this.createdDate = createdDate;
        this.rd = false;
        this.expirationTime = LocalDateTime.now().plusDays(1);
    }

    public void readNotification() {
        this.rd = true;
        this.expirationTime = LocalDateTime.now().plusHours(6);
    }
}
