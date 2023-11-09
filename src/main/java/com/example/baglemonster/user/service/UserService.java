package com.example.baglemonster.user.service;

import com.example.baglemonster.user.dto.SignupRequestDto;
import com.example.baglemonster.user.entity.UserRoleEnum;
import com.example.baglemonster.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequestDto requestDto) {
        String password = passwordEncoder.encode(requestDto.getPassword());

        checkDuplicateEmail(requestDto.getEmail());

        UserRoleEnum role = Boolean.TRUE.equals(requestDto.getIsStore()) ? UserRoleEnum.STORE : UserRoleEnum.USER;

        userRepository.save(requestDto.toEntity(password, role));
    }

    private void checkDuplicateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }
}
