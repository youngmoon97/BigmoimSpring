package com.bigmoim.module.admin.controller;

import com.bigmoim.module.admin.service.AdminService;
import com.bigmoim.module.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
}
