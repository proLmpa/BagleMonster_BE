package com.example.baglemonster.notification.repository;

import com.example.baglemonster.cart.entity.Cart;
import com.example.baglemonster.notification.entity.Notification;
import com.example.baglemonster.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByUser(User user);

    void deleteByExpirationTimeBefore(LocalDateTime now);

    Optional<Notification> findByCart(Cart order);
}
