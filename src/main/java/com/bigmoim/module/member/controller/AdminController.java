package com.bigmoim.module.member.controller;

import com.bigmoim.module.member.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/index")
    public String index(){return "/admin/index";}

    @GetMapping("/memberManage")
    public String memberManage(){return "/admin/memberManage";}

    @GetMapping("/moimManage")
    public String moimManage(){return "/admin/moimManage";}
}
