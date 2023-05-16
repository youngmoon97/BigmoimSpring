package com.bigmoim.module.moim.controller;

import com.bigmoim.module.member.service.MemberService;
import com.bigmoim.module.moim.service.MoimService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/moim")
public class MoimController {
    private final MoimService moimService;
}
