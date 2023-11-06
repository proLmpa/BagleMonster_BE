package com.example.baglemonster.user.controller;

import com.example.baglemonster.user.dto.SignupRequestDto;
import com.example.baglemonster.user.entity.User;
import com.example.baglemonster.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signup(SignupRequestDto signupRequestDto) {

    }

    private void checkDuplicateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 회원입니다."));
    }
}
