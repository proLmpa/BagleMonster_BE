package com.example.baglemonster.store.controller;

import com.example.baglemonster.common.dto.ApiResponseDto;
import com.example.baglemonster.security.UserDetailsImpl;
import com.example.baglemonster.store.dto.StoresResponseDto;
import com.example.baglemonster.store.dto.StoreRequestDto;
import com.example.baglemonster.store.dto.StoreResponseDto;
import com.example.baglemonster.store.service.StoreService;
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
@Tag(name = "가게 API", description = "가게의 동작과 관련된 API 정보를 담고 있습니다.")
public class StoreController {
    private final StoreService storeService;

    @Operation(summary = "가게 전체 조회")
    @GetMapping("/stores")
    public ResponseEntity<StoresResponseDto> selectStoreList() {
        StoresResponseDto result = storeService.selectStoreList();
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "가게 단일 조회")
    @GetMapping("/stores/{storeId}")
    public ResponseEntity<StoreResponseDto> selectStore(@PathVariable Long storeId) {
        StoreResponseDto result = storeService.selectStore(storeId);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "가게 등록")
    @PostMapping("/stores")
    public ResponseEntity<ApiResponseDto> createStore(@RequestBody StoreRequestDto storeRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        storeService.createStore(storeRequestDto, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "가게가 등록되었습니다."));
    }

    @Operation(summary = "가게 수정")
    @PutMapping("/stores/{storeId}")
    public ResponseEntity<ApiResponseDto> modifyStore(@PathVariable Long storeId, @RequestBody StoreRequestDto storeRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        storeService.modifyStore(storeId, storeRequestDto, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "가게가 수정되었습니다."));
    }

    @Operation(summary = "가게 삭제")
    @PutMapping("/stores/{storeId}")
    public ResponseEntity<ApiResponseDto> deleteStore(@PathVariable Long storeId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        storeService.deleteStore(storeId, userDetails.getUser());
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.NO_CONTENT.value(), "가게가 삭제되었습니다."));
    }
}
