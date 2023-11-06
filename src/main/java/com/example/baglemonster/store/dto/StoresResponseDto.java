package com.example.baglemonster.store.dto;

import com.example.baglemonster.store.entity.Store;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StoresResponseDto {
    private List<StoreResponseDto> stores;
    public static StoresResponseDto of(List<Store> stores) {
        List<StoreResponseDto> storesResponseDto = stores.stream().map(
                StoreResponseDto::of).toList();

        return StoresResponseDto.builder()
                .stores(storesResponseDto)
                .build();
    }
}
