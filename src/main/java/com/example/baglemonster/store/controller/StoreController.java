package com.example.baglemonster.store.controller;

import com.example.baglemonster.common.dto.ApiResponseDto;
import com.example.baglemonster.security.UserDetailsImpl;
import com.example.baglemonster.store.dto.StoresResponseDto;
import com.example.baglemonster.store.dto.StoreRequestDto;
import com.example.baglemonster.store.dto.StoreDetailResponseDto;
import com.example.baglemonster.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "가게 API", description = "가게의 동작과 관련된 API 정보를 담고 있습니다.")
public class StoreController {
    private final StoreService storeService;

    @Operation(summary = "가게 전체 조회")
    @GetMapping("/stores")
    public ResponseEntity<StoresResponseDto> selectStores() {
        StoresResponseDto result = storeService.selectStores();
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "가게 단일 조회")
    @GetMapping("/stores/{storeId}")
    public ResponseEntity<StoreDetailResponseDto> selectStore(@PathVariable Long storeId) {
        StoreDetailResponseDto result = storeService.selectStore(storeId);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "가게 등록")
    @PostMapping("/stores")
    public ResponseEntity<ApiResponseDto> createStore(@RequestPart(value = "requestDto") StoreRequestDto storeRequestDto,
                                                      @RequestPart(value = "picture", required = false) MultipartFile file,
                                                      @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        storeService.createStore(storeRequestDto, file, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "가게가 등록되었습니다."));
    }

    @Operation(summary = "내 가게 조회")
    @GetMapping("/stores/mystore")
    public ResponseEntity<StoreDetailResponseDto> selectMyStore(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        StoreDetailResponseDto result = storeService.selectMyStore(userDetails.getUser());
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "가게 수정")
    @PutMapping("/stores/{storeId}")
    public ResponseEntity<ApiResponseDto> modifyStore(@PathVariable Long storeId, @RequestPart(value = "requestDto") StoreRequestDto storeRequestDto,
                                                      @RequestPart(value = "picture", required = false) MultipartFile file,
                                                      @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        storeService.modifyStore(storeId, storeRequestDto, file, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "가게가 수정되었습니다."));
    }

    @Operation(summary = "가게 삭제")
    @DeleteMapping("/stores/{storeId}")
    public ResponseEntity<ApiResponseDto> deleteStore(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        storeService.deleteStore(storeId, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.NO_CONTENT.value(), "가게가 삭제되었습니다."));
    }
}
