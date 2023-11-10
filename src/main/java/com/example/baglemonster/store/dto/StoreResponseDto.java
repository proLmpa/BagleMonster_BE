package com.example.baglemonster.store.dto;

import com.example.baglemonster.product.dto.ProductResponseDto;
import com.example.baglemonster.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponseDto {
    private Long storeId;
    private String name;
    private String address;
    private String storePictureUrl;
    private String phone;
    private String content;
    private LocalTime productCreatedTime;
    private LocalTime openedTime;
    private LocalTime closedTime;
    private String closedDays;
    private List<ProductResponseDto> products;

    public static StoreResponseDto of(Store store, boolean isDetail) {
        String noImageUrl = "https://baglemonster.s3.ap-northeast-2.amazonaws.com/no_image.jpg";
        String pictureUrl = (store.getStorePictureUrl() == null) ? noImageUrl : store.getStorePictureUrl();

        return StoreResponseDto.builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .storePictureUrl(pictureUrl)
                .phone(store.getPhone())
                .content(store.getContent())
                .productCreatedTime(store.getProductCreatedTime())
                .openedTime(store.getOpenedTime())
                .closedTime(store.getClosedTime())
                .closedDays(store.getClosedDays())
                .products(isDetail? store.getProducts().stream().map(ProductResponseDto::of).toList() : null)
                .build();
    }
}
