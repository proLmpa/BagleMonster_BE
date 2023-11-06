package com.example.baglemonster.store.entity;

import com.example.baglemonster.common.entity.Timestamped;
import com.example.baglemonster.store.dto.StoreRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name="stores")
public class Store extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "storePictureUrl")
    private String storePictureUrl;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "productCreatedTime", nullable = false)
    private LocalTime productCreatedTime;

    @Column(name = "openedTime", nullable = false)
    private LocalTime openedTime;

    @Column(name = "closedTime", nullable = false)
    private LocalTime closedTime;

    @Column(name = "closedDays", nullable = false)
    private String closedDays;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public void editStore(StoreRequestDto storeRequestDto) {
        this.name = storeRequestDto.getName();
        this.address = storeRequestDto.getAddress();
        this.storePictureUrl = storeRequestDto.getStorePictureUrl();
        this.phone = storeRequestDto.getPhone();
        this.content = storeRequestDto.getContent();
        this.productCreatedTime = storeRequestDto.getProductCreatedTime();
        this.openedTime = storeRequestDto.getOpenedTime();
        this.closedTime = storeRequestDto.getClosedTime();
        this.closedDays = storeRequestDto.getClosedDays();
    }
}
