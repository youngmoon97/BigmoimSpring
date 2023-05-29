package com.bigmoim.module.member.controller;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.member.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @GetMapping("/signup")
    public String getSignupPage(Model model){
        AuthDTO.ResSignup authDto = authService.getAllList();
        model.addAttribute("authDto", authDto);
        return "/login/signup";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "/login/login";
    }
    @GetMapping("/idFind")
    public String getFindIdPage(){
        return "/login/idFind";
    }
    @GetMapping("/pwFind")
    public String getFindPwPage(){
        return "/login/pwFind";
    }

}
