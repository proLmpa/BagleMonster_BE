package com.example.baglemonster.product.dto;

import com.example.baglemonster.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductsResponseDto {
    private List<ProductResponseDto> products;
    public static ProductsResponseDto of(List<Product> products) {
        List<ProductResponseDto> productsResponseDto = products.stream().map(
                ProductResponseDto::of).toList();

        return ProductsResponseDto.builder()
                .products(productsResponseDto)
                .build();
    }
}
