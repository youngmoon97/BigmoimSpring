package com.bigmoim.module.moim.controller;

import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.moim.dto.MainDTO;
import com.bigmoim.module.moim.dto.MoimDetailDTO;
import com.bigmoim.module.moim.service.MoimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/moim/moimdetail")
public class MoimController {
    private final MoimService moimService;

    @GetMapping("{moimNum}")
    public String getMoimDetail(@PathVariable("moimNum") Integer moimNum,
                                @AuthenticationPrincipal CustomUserDetails customUserDetails,
                                Model model){
        MoimDetailDTO.ResMoimDetail dto = moimService.getMoimDetail(customUserDetails,moimNum);
        System.out.println(dto);
        model.addAttribute("dto", dto);
        return "/moim/moimdetail";
    }
}
