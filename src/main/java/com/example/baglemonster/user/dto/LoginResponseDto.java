package com.example.baglemonster.user.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private String name;
    private Boolean isStore;

    public LoginResponseDto(String name, Boolean isStore) {
        this.name = name;
        this.isStore = isStore;
    }
}
