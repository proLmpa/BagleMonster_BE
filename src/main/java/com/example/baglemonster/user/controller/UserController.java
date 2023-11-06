package com.example.baglemonster.user.controller;

import com.example.baglemonster.common.dto.ApiResponseDto;
import com.example.baglemonster.user.dto.LoginRequestDto;
import com.example.baglemonster.user.dto.SignupRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "사용자 API", description = "사용자의 동작과 관련된 API 정보를 담고 있습니다.")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입")
    @PostMapping("/users/signup")
    public ResponseEntity<ApiResponseDto> signup(@Validated @RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "회원가입에 성공하셨습니다."));
    }

    @Operation(summary = "로그인")
    @PostMapping("/users/signin")
    public ResponseEntity<ApiResponseDto> signin(@RequestBody LoginRequestDto loginRequestDto) {
        // 실제 로그인은 JWT 인증 필터에서 진행되며, 이 메서드는 Swagger에서 로그인 동작을 확인하기 위해 제작되었습니다.
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "로그인에 성공하셨습니다."));
    }
}
