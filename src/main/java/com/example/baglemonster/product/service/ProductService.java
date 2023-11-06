package com.example.baglemonster.product.service;

import com.example.baglemonster.common.exception.UnauthorizedException;
import com.example.baglemonster.product.dto.ProductRequestDto;
import com.example.baglemonster.product.dto.ProductResponseDto;
import com.example.baglemonster.product.dto.ProductsResponseDto;
import com.example.baglemonster.product.entity.Product;
import com.example.baglemonster.product.repository.ProductRepository;
import com.example.baglemonster.store.entity.Store;
import com.example.baglemonster.store.service.StoreService;
import com.example.baglemonster.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final StoreService storeService;

    // 상품 등록
    @Transactional
    public void createProduct(Long storeId, ProductRequestDto productRequestDto, User user) {
        Store store = storeService.findStore(storeId);

        if (!store.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("상품 등록에 대한 권한이 없습니다.");
        }

        Product product = productRequestDto.toEntity(store);
        productRepository.save(product);
    }

    // 상품 목록 조회
    @Transactional(readOnly = true)
    public ProductsResponseDto selectProducts() {
        List<Product> products = productRepository.findAll().stream().toList();
        return ProductsResponseDto.of(products);
    }

    // 상품 상세 조회
    @Transactional(readOnly = true)
    public ProductResponseDto selectProduct(Long productId) {
        Product product = findProduct(productId);
        return ProductResponseDto.of(product);
    }

    // 상품 수정
    @Transactional
    public void modifyProduct(Long storeId, Long productId, ProductRequestDto productRequestDto, User user) {
        // 관리자 수정 권한 협의 필요
        Store store = storeService.findStore(storeId);
        Product product = findProduct(productId);

        if (!store.getUser().getId().equals(user.getId()) || !product.getStore().getId().equals(storeId)) {
            throw new UnauthorizedException("상품 수정에 대한 권한이 없습니다.");
        }

        product.editProduct(productRequestDto);
    }

    // 상품 삭제
    @Transactional
    public void deleteProduct(Long storeId, Long productId, User user) {
        // 관리자 삭제 권한 협의 필요
        Store store = storeService.findStore(storeId);
        Product product = findProduct(productId);

        if (!store.getUser().getId().equals(user.getId()) || !product.getStore().getId().equals(storeId)) {
            throw new UnauthorizedException("상품 삭제에 대한 권한이 없습니다.");
        }

        productRepository.delete(product);
    }

    // ID로 상품 찾기
    private Product findProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() ->
                new IllegalArgumentException("선택한 상품은 존재하지 않습니다.")
        );
    }
}
