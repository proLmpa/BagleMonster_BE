package com.example.baglemonster.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;
}
