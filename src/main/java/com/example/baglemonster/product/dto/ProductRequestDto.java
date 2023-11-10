package com.example.baglemonster.product.dto;

import com.example.baglemonster.product.entity.Product;
import com.example.baglemonster.store.entity.Store;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductRequestDto {

    private String name;
    private String description;
    private Integer price;
    private Boolean status;

    public Product toEntity(Store store, String productPictureUrl) {
        return Product.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .productPictureUrl(productPictureUrl)
                .status(this.status)
                .store(store)
                .build();
    }
}
