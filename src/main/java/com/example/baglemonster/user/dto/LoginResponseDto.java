package com.example.baglemonster.user.dto;

import com.example.baglemonster.user.entity.User;
import com.example.baglemonster.user.entity.UserRoleEnum;
import lombok.Getter;

@Getter
public class LoginResponseDto {
    private String name;
    private String phone;
    private Boolean isStore;

    public LoginResponseDto(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
        this.isStore = user.getRole().equals(UserRoleEnum.STORE);
    }
}
