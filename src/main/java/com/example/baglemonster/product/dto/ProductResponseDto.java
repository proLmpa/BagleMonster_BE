package com.example.baglemonster.product.dto;

import com.example.baglemonster.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer price;
    private String productPictureUrl;
    private Integer popularity;
    private Boolean status;

    public static ProductResponseDto of(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .productPictureUrl(product.getProductPictureUrl())
                .popularity(product.getPopularity())
                .status(product.getStatus())
                .build();
    }
}
