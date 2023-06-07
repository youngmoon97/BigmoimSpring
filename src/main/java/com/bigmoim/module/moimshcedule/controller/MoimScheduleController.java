package com.bigmoim.module.moimshcedule.controller;

import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.moimshcedule.dto.MoimScheduleDTO;
import com.bigmoim.module.moimshcedule.service.MoimScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/moim")
public class MoimScheduleController {
    private final MoimScheduleService moimScheduleService;

    @GetMapping("/moimschedule")
    public String getMoimSchedulePage(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                      Model model){
        MoimScheduleDTO.ResMoimSchedule dto = moimScheduleService.getMoimSchedule(customUserDetails);
        model.addAttribute("dto", dto);
        System.out.println(model);
        return "moim/moimschedule";
    }
}
