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
    private Long productId;
    private String storeName;
    private String name;
    private String description;
    private Integer price;
    private String productPictureUrl;
    private Integer popularity;
    private Boolean status;

    public static ProductResponseDto of(Product product) {
        String noImageUrl = "https://baglemonster.s3.ap-northeast-2.amazonaws.com/no_image.jpg";
        String pictureUrl = (product.getProductPictureUrl() == null) ? noImageUrl : product.getProductPictureUrl();

        return ProductResponseDto.builder()
                .productId(product.getId())
                .storeName(product.getStore().getName())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .productPictureUrl(pictureUrl)
                .popularity(product.getPopularity())
                .status(product.getStatus())
                .build();
    }
}
