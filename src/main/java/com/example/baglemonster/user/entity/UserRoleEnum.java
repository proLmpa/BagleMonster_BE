package com.example.baglemonster.user.entity;

public enum UserRoleEnum {
    USER(Authority.USER),
    STORE(Authority.STORE),
    ADMIN(Authority.ADMIN);

    private final String authority;

    UserRoleEnum(String authoirty) {
        this.authority = authoirty;
    }

    public String getAuthority() { return this.authority; }

    private static class Authority {
        public static final String USER = "USER";

        public static final String STORE = "STORE";

        public static final String ADMIN = "ADMIN";
    }
}
