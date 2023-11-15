package com.example.baglemonster.cart.entity;

public enum StoreStatusEnum {
    NEWORDER(Status.NEWORDER), READ(Status.READ), SOLD(Status.SOLD), CANCELED(Status.CANCELED);

    private final String status;

    StoreStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() { return this.status; }

    private static class Status {
        public static final String NEWORDER = "NEWORDER";

        public static final String READ = "READ";

        public static final String SOLD = "SOLD";

        public static final String CANCELED = "CANCELED";
    }
}
