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
@Table(name="products")
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

//   주문 수에 따른 인기도 -> 주문 CRUD 완료 후 마무리 예정 -> 현재 null로 채워짐
    @Column(name = "popularity")
    private Integer popularity;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    public void editProduct(ProductRequestDto productRequestDto, String productPictureUrl) {
        this.name = productRequestDto.getName();
        this.price = productRequestDto.getPrice();
        this.productPictureUrl = productPictureUrl;
        this.status = productRequestDto.getStatus();
    }
}
