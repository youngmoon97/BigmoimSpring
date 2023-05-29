package com.bigmoim.module.moim.controller;

import com.bigmoim.module.moim.dto.MoimDTO;
import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.moim.service.MoimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MoimController {
    private final MoimService moimService;

    @GetMapping
    public String getMainPage(Model model){
        MoimDTO.ResBasic mainDto = moimService.getClassList();
        model.addAttribute("mainDto",mainDto);
        return "/main/main";
    }
}
