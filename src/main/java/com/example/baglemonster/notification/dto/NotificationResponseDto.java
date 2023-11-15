package com.example.baglemonster.notification.dto;

import com.example.baglemonster.common.entity.DurationFormatter;
import com.example.baglemonster.notification.entity.Notification;
import lombok.Getter;

@Getter
public class NotificationResponseDto {
    private Long id;
    private Long storeId;
    private Long cartId;
    private String content;
    private String timeSinceCreated;
    private Boolean rd;

    public NotificationResponseDto(Notification notification) {
        this.id = notification.getId();
        this.storeId = notification.getCart().getStore().getId();
        this.cartId = notification.getCart().getId();
        this.content = notification.getContent();
        this.timeSinceCreated = DurationFormatter.format(notification.getCreatedAt());
        this.rd = notification.getRd();
    }
}
