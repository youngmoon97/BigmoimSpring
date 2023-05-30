package com.bigmoim.module.moim.controller;

import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.moim.dto.MainDTO;
import com.bigmoim.module.moim.service.MoimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {
    private final MoimService moimService;

    @GetMapping
    public String getMainPage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model){
        MainDTO.ResBasic mainDto = moimService.getMainList(customUserDetails);
//        System.out.println(mainDto.getMember());
        model.addAttribute("dto",mainDto);
        return "/main/main";
    }
}
