package com.example.baglemonster.store.service;

import com.example.baglemonster.common.exception.UnauthorizedException;
import com.example.baglemonster.store.dto.StoresResponseDto;
import com.example.baglemonster.store.dto.StoreRequestDto;
import com.example.baglemonster.store.dto.StoreResponseDto;
import com.example.baglemonster.store.entity.Store;
import com.example.baglemonster.store.repository.StoreRepository;
import com.example.baglemonster.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    // 가게 전체 조회
    @Transactional(readOnly = true)
    public StoresResponseDto selectStoreList() {
        List<Store> storeList = storeRepository.findAll().stream().toList();
        return StoresResponseDto.of(storeList);
    }

    // 가게 단일 조회
    @Transactional(readOnly = true)
    public StoreResponseDto selectStore(Long storeId) {
        Store store = findStore(storeId);
        return StoreResponseDto.of(store);
    }

    // 가게 등록
    @Transactional
    public void createStore(StoreRequestDto storeRequestDto, User user) {
        if (!user.getRole().getAuthority().equals("STORE")) {
            throw new UnauthorizedException("가게 등록에 대한 권한이 없습니다.");
        }

        Store store = storeRequestDto.toEntity();
        storeRepository.save(store);
    }

    // 가게 수정
    @Transactional
    public void modifyStore(Long storeId, StoreRequestDto storeRequestDto, User user) {
        // 관리자 수정 권한 협의 필요
        if (!user.getRole().getAuthority().equals("STORE")) {
            throw new UnauthorizedException("가게 수정에 대한 권한이 없습니다.");
        }

        Store store = findStore(storeId);
        store.editStore(storeRequestDto);
    }

    // 가게 삭제
    @Transactional
    public void deleteStore(Long storeId, User user) {
        // 관리자 삭제 권한 협의 필요
        if (!user.getRole().getAuthority().equals("STORE")) {
            throw new UnauthorizedException("가게 삭제에 대한 권한이 없습니다.");
        }

        Store store = findStore(storeId);
        storeRepository.delete(store);
    }

    // 정시, 매시 30분마다 상태 체크 및 변경?
//    private void checkStatus() {
//    }

    // ID로 가게 찾기
    private Store findStore(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(() ->
                new IllegalArgumentException("선택한 가게는 존재하지 않습니다.")
        );
    }
}
