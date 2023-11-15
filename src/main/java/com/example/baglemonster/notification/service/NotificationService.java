package com.example.baglemonster.notification.service;

import com.example.baglemonster.common.exception.NotFoundException;
import com.example.baglemonster.notification.dto.NotificationResponseDto;
import com.example.baglemonster.notification.entity.Notification;
import com.example.baglemonster.notification.repository.EmitterRepository;
import com.example.baglemonster.notification.repository.NotificationRepository;
import com.example.baglemonster.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final static String NOTIFICATION_NAME = "notification";
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60;

    private final NotificationRepository notificationRepository;
    private final EmitterRepository emitterRepository;

    // 알림 생성 및 실시간 알림 보내기
    @Transactional
    public void saveNotification(Notification notification, Long receiverId) {
        notificationRepository.save(notification);
        sendEmitter(notification, receiverId);
    }

    // 알림 전체 조회
    @Transactional(readOnly = true)
    public List<NotificationResponseDto> getNotifications(User user) {
        return notificationRepository.findAllByUser(user)
                .stream().map(NotificationResponseDto::new).toList();
    }

    // 알림 DB 30분마다 삭제하기
    @Transactional
    @Scheduled(fixedRate = 1800000) // 30분마다 실행
    public void cleanupExpiredNotifications() {
        notificationRepository.deleteByExpirationTimeBefore(LocalDateTime.now());
    }

    // 실시간 통신 SSE 보내기
    public void sendEmitter(Notification notification, Long receiverId) {
        emitterRepository.get(receiverId).ifPresentOrElse(it -> {
                    try {
                        it.send(SseEmitter.event()
                                .id("")
                                .name(NOTIFICATION_NAME)
                                .data(new NotificationResponseDto(notification)));
                        log.info("SseEmitter send ok");
                    } catch (IOException exception) {
                        emitterRepository.delete(receiverId);
                        log.info("SseEmitter send failed");
                        throw new NotFoundException("Connection failed");
                    }
                },
                () -> log.info("No emitter founded")
        );
    }

    // 실시간 통신 SSE 연결
    public SseEmitter connectNotification(Long userId) {
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        emitterRepository.save(userId, emitter);
        emitter.onCompletion(() -> emitterRepository.delete(userId));
        emitter.onTimeout(() -> emitterRepository.delete(userId));

        try {
            log.info("send");
            emitter.send(SseEmitter.event()
                    .id("id")
                    .name(NOTIFICATION_NAME)
                    .data("connect completed"));
        } catch (IOException exception) {
            throw new IllegalArgumentException("connect failed");
        }
        return emitter;
    }
}
