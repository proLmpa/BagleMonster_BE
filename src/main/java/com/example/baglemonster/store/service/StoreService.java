package com.example.baglemonster.store.service;

import com.example.baglemonster.common.exception.NotFoundException;
import com.example.baglemonster.common.exception.UnauthorizedException;
import com.example.baglemonster.store.dto.StoreRequestDto;
import com.example.baglemonster.store.dto.StoreResponseDto;
import com.example.baglemonster.store.dto.StoresResponseDto;
import com.example.baglemonster.store.entity.Store;
import com.example.baglemonster.store.repository.StoreRepository;
import com.example.baglemonster.user.entity.User;
import com.example.baglemonster.user.entity.UserRoleEnum;
import com.example.baglemonster.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    // 가게 전체 조회
    @Transactional(readOnly = true)
    public StoresResponseDto selectStores() {
        List<Store> stores = storeRepository.findAll().stream().toList();
        return StoresResponseDto.of(stores);
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
        if (!user.getRole().getAuthority().equals(UserRoleEnum.STORE.getAuthority())) {
            throw new UnauthorizedException("가게 등록에 대한 권한이 없습니다.");
        }

        Store store = storeRequestDto.toEntity(user);
        storeRepository.save(store);
    }

    // 내 가게 조회
    @Transactional(readOnly = true)
    public StoreResponseDto selectMyStore(User user) {
        User storeUser = findUser(user.getId());
        Store store = storeRepository.findByUser(storeUser);

        if (store == null) {
            throw new NotFoundException("가게가 존재하지 않습니다.");
        }

        return StoreResponseDto.of(store);
    }

    // 가게 수정
    @Transactional
    public void modifyStore(Long storeId, StoreRequestDto storeRequestDto, User user) {
        // 관리자 수정 권한 협의 필요
        Store store = findStore(storeId);

        if (!store.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("가게 수정에 대한 권한이 없습니다.");
        }

        store.editStore(storeRequestDto);
    }

    // 가게 삭제
    @Transactional
    public void deleteStore(Long storeId, User user) {
        // 관리자 삭제 권한 협의 필요
        Store store = findStore(storeId);

        if (!store.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("가게 삭제에 대한 권한이 없습니다.");
        }

        storeRepository.delete(store);
    }

    // ID로 가게 찾기
    public Store findStore(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow(() ->
                new NotFoundException("선택한 가게는 존재하지 않습니다.")
        );
    }

    // ID로 유저 찾기
    public User findUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
