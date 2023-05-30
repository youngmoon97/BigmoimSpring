package com.bigmoim.module.member.controller;

import com.bigmoim.module.member.dto.AdminDTO;
import com.bigmoim.module.member.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/login")
    public String login(){
        return "/login/login";
    }

    @GetMapping("/index")
    public String index(){return "/admin/index";}

    @GetMapping("/memberManage")
    public String getMemberList(Model model){
        AdminDTO.ResMember adminDto = adminService.getMemberList();
        //System.out.println(adminDto); //데이터 가져오는거 확인용
        model.addAttribute("adminDto", adminDto);
        return "/admin/memberManage";
    }

    @GetMapping("/moimManage")
    public String moimManage(Model model){
        AdminDTO.ResMoim adminDto = adminService.getMoimList();
        model.addAttribute("adminDto", adminDto);
        return "/admin/moimManage";
    }
}
