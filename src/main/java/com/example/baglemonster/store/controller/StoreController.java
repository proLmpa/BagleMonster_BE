package com.example.baglemonster.store.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "가게 API", description = "가게의 동작과 관련된 API 정보를 담고 있습니다.")
public class StoreController {
}
