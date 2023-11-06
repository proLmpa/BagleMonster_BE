package com.example.baglemonster.store.dto;

import com.example.baglemonster.store.entity.Store;
import lombok.*;

import java.time.LocalTime;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreRequestDto {

    private String name;
    private String address;
    private String storePictureUrl;
    private String phone;
    private String content;
    private LocalTime productCreatedTime;
    private LocalTime openedTime;
    private LocalTime closedTime;
    private String closedDays;

    public Store toEntity() {
        return Store.builder()
                .name(this.name)
                .address(this.address)
                .storePictureUrl(this.storePictureUrl)
                .phone(this.phone)
                .content(this.content)
                .productCreatedTime(this.productCreatedTime)
                .openedTime(this.openedTime)
                .closedTime(this.closedTime)
                .closedDays(this.closedDays)
                .status(checkOperationTime(openedTime, closedTime))
                .build();
    }

    private Boolean checkOperationTime(LocalTime openedTime, LocalTime closedTime) {
        LocalTime currentTime = LocalTime.now();

        // 시간 범위가 하루를 넘어가는 경우에 대비하여 처리
        if (openedTime.isAfter(closedTime)) {
            return currentTime.isAfter(openedTime) || currentTime.isBefore(closedTime);
        } else {
            return currentTime.isAfter(openedTime) && currentTime.isBefore(closedTime);
        }
    }
}
