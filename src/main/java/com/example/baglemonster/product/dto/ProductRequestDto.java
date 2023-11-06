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
    private Integer price;
    private String productPictureUrl;
    private Boolean status;

    public Product toEntity(Store store) {
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .productPictureUrl(this.productPictureUrl)
                .status(this.status)
                .store(store)
                .build();
    }
}
