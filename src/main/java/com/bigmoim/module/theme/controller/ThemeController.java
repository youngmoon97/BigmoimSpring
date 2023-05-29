package com.bigmoim.module.theme.controller;

import com.bigmoim.module.theme.dto.ThemeDTO;
import com.bigmoim.module.theme.service.ThemeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/themeList")
public class ThemeController {
    private final ThemeService themeService;

    @GetMapping
    public String getThemePage(Model model){
        ThemeDTO.ResBasic resDto = themeService.getThemeList();
//        System.out.println(resDto);
        model.addAttribute("resDto", resDto);
        return "/main/themeList";
    }

}
