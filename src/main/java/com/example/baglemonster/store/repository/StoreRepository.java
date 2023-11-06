package com.example.baglemonster.store.repository;

import com.example.baglemonster.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
