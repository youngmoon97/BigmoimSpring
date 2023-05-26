package com.bigmoim.module.theme.controller;

import com.bigmoim.module.theme.service.ThemeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/themeList")
public class ThemeController {
    private final ThemeService themeService;

    @GetMapping
    public HttpEntity<?> getThemeList(){
        log.info("테마 리스트를 가져옵니다");
        return themeService.themeList();
    }

}
