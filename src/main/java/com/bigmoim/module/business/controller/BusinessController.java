package com.bigmoim.module.business.controller;

import com.bigmoim.module.business.dto.BusinessDTO;
import com.bigmoim.module.business.service.BusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/businessList")
public class BusinessController {
    private final BusinessService businessService;

    @GetMapping
    public String getBusinessList(Model model){
        BusinessDTO.ResBasic resDto = businessService.getBusinessList();
//        System.out.println(resDto);
        model.addAttribute("resDto", resDto);
        return "/main/businessList";
    }
}
