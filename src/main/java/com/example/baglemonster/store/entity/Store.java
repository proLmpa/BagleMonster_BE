package com.example.baglemonster.store.entity;

import com.example.baglemonster.common.entity.Timestamped;
import com.example.baglemonster.store.dto.StoreRequestDto;
import com.example.baglemonster.user.entity.User;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

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
        this.status = checkOperationTime(openedTime, closedTime);
    }

    public static Boolean checkOperationTime(LocalTime openedTime, LocalTime closedTime) {
        LocalTime currentTime = LocalTime.now();

        // 시간 범위가 하루를 넘어가는 경우에 대비하여 처리
        if (openedTime.isAfter(closedTime)) {
            return currentTime.isAfter(openedTime) || currentTime.isBefore(closedTime);
        } else {
            return currentTime.isAfter(openedTime) && currentTime.isBefore(closedTime);
        }
    }
}
