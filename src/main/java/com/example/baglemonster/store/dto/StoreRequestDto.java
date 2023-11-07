package com.example.baglemonster.store.dto;

import com.example.baglemonster.store.entity.Store;
import com.example.baglemonster.user.entity.User;
import lombok.*;

import java.time.LocalTime;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreRequestDto {

    private String name;
    private String address;
    private String phone;
    private String content;
    private LocalTime productCreatedTime;
    private LocalTime openedTime;
    private LocalTime closedTime;
    private String closedDays;

    public Store toEntity(User user, String storePictureUrl) {
        return Store.builder()
                .name(this.name)
                .address(this.address)
                .storePictureUrl(storePictureUrl)
                .phone(this.phone)
                .content(this.content)
                .productCreatedTime(this.productCreatedTime)
                .openedTime(this.openedTime)
                .closedTime(this.closedTime)
                .closedDays(this.closedDays)
                .user(user)
                .build();
    }
}
