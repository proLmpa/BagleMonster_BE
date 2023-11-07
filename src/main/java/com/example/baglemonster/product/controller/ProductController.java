package com.example.baglemonster.product.controller;

import com.example.baglemonster.common.dto.ApiResponseDto;
import com.example.baglemonster.product.dto.ProductRequestDto;
import com.example.baglemonster.product.dto.ProductResponseDto;
import com.example.baglemonster.product.dto.ProductsResponseDto;
import com.example.baglemonster.product.service.ProductService;
import com.example.baglemonster.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "상품 API", description = "상품의 동작과 관련된 API 정보를 담고 있습니다.")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "상품 등록")
    @PostMapping("/stores/{storeId}/products")
    public ResponseEntity<ApiResponseDto> createProduct(@PathVariable Long storeId, @RequestBody ProductRequestDto productRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        productService.createProduct(storeId, productRequestDto, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "상품이 등록되었습니다."));
    }

    @Operation(summary = "상품 목록 조회")
    @GetMapping("/stores/{storeId}/products")
    public ResponseEntity<ProductsResponseDto> selectProducts() {
        ProductsResponseDto result = productService.selectProducts();
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "상품 상세 조회")
    @GetMapping("/stores/{storeId}/products/{productId}")
    public ResponseEntity<ProductResponseDto> selectProduct(@PathVariable Long productId) {
        ProductResponseDto result = productService.selectProduct(productId);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "상품 수정")
    @PutMapping("/stores/{storeId}/products/{productId}")
    public ResponseEntity<ApiResponseDto> modifyProduct(@PathVariable Long storeId, @PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        productService.modifyProduct(storeId, productId, productRequestDto, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "상품이 수정되었습니다."));
    }

    @Operation(summary = "상품 삭제")
    @DeleteMapping("/stores/{storeId}/products/{productId}")
    public ResponseEntity<ApiResponseDto> deleteProduct(@PathVariable Long storeId, @PathVariable Long productId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        productService.deleteProduct(storeId, productId, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.NO_CONTENT.value(), "상품이 삭제되었습니다."));
    }
}
