package com.example.baglemonster.notification.controller;

import com.example.baglemonster.common.security.UserDetailsImpl;
import com.example.baglemonster.notification.dto.NotificationResponseDto;
import com.example.baglemonster.notification.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "알림 관련 API", description = "알림 관련 API 입니다.")
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/users/notifications")
    @Operation(summary = "알림 전체 조회", description = "로그인 한 유저의 정보를 가져와, 해당 유저에게 온 알림을 모두 조회합니다.")
    public List<NotificationResponseDto> getNotifications(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return notificationService.getNotifications(userDetails.getUser());
    }

    // 알림 실시간 통신 SSE 적용
    @GetMapping(value = "/users/notifications/subscribe")
    public SseEmitter subscribe(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        log.info("subscribe");
        return notificationService.connectNotification(userDetails.getUser().getId());
    }

}
