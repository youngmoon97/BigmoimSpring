package com.bigmoim.module.zipcode.controller;

import com.bigmoim.module.member.service.MemberService;
import com.bigmoim.module.zipcode.service.ZipcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/zipcode")
public class ZipcodeController {
    private final ZipcodeService zipcodeService;
}
