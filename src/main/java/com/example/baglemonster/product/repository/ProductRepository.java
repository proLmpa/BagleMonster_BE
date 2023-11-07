package com.example.baglemonster.product.repository;

import com.example.baglemonster.product.entity.Product;
import com.example.baglemonster.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStore(Store store);
}
