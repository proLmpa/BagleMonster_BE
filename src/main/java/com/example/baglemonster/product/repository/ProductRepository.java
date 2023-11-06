package com.example.baglemonster.product.repository;

import com.example.baglemonster.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
