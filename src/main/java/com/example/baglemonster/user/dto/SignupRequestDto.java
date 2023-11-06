package com.example.baglemonster.user.dto;

import com.example.baglemonster.user.entity.User;
import com.example.baglemonster.user.entity.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SignupRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "비밀번호는 영문자/숫자/특수문자 포함 8자리 이상이어야 합니다.")
    private String password;

    private String phone;

    public User toEntity(String encodedPassword, UserRoleEnum role) {
        return User.builder()
                .name(name)
                .email(email)
                .password(encodedPassword)
                .role(role)
                .phone(phone)
                .build();
    }
}
