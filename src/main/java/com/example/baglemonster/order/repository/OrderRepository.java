package com.example.baglemonster.order.repository;

import com.example.baglemonster.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
