package com.example.baglemonster.product.entity;

import com.example.baglemonster.common.entity.Timestamped;
import com.example.baglemonster.product.dto.ProductRequestDto;
import com.example.baglemonster.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name="stores")
public class Product extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "productPictureUrl")
    private String productPictureUrl;

    @Column(name = "popularity")
    private Integer popularity;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    public void editProduct(ProductRequestDto productRequestDto) {
        this.name = productRequestDto.getName();
        this.price = productRequestDto.getPrice();
        this.productPictureUrl = productRequestDto.getProductPictureUrl();
        this.status = productRequestDto.getStatus();
    }
}
