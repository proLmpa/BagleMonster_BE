package com.example.baglemonster.store.dto;

import com.example.baglemonster.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponseDto {
    private Long id;
    private String name;
    private String address;
    private String storePictureUrl;
    private String phone;
    private String content;
    private LocalTime productCreatedTime;
    private LocalTime openedTime;
    private LocalTime closedTime;
    private String closedDays;

    public static StoreResponseDto of(Store store) {
        String noImageUrl = "https://baglemonster.s3.ap-northeast-2.amazonaws.com/no_image.jpg";
        String pictureUrl = (store.getStorePictureUrl() == null) ? noImageUrl : store.getStorePictureUrl();

        return StoreResponseDto.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .storePictureUrl(pictureUrl)
                .phone(store.getPhone())
                .content(store.getContent())
                .productCreatedTime(store.getProductCreatedTime())
                .openedTime(store.getOpenedTime())
                .closedTime(store.getClosedTime())
                .closedDays(store.getClosedDays())
                .build();
    }
}
