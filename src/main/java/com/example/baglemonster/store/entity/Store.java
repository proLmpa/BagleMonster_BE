package com.example.baglemonster.store.entity;

import com.example.baglemonster.common.entity.Timestamped;
import com.example.baglemonster.product.entity.Product;
import com.example.baglemonster.store.dto.StoreRequestDto;
import com.example.baglemonster.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "store", orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public void editStore(StoreRequestDto storeRequestDto, String storePictureUrl) {
        this.name = storeRequestDto.getName();
        this.address = storeRequestDto.getAddress();
        this.storePictureUrl = storePictureUrl;
        this.phone = storeRequestDto.getPhone();
        this.content = storeRequestDto.getContent();
        this.productCreatedTime = storeRequestDto.getProductCreatedTime();
        this.openedTime = storeRequestDto.getOpenedTime();
        this.closedTime = storeRequestDto.getClosedTime();
        this.closedDays = storeRequestDto.getClosedDays();
    }
}
