package com.bigmoim.module.business.controller;

import com.bigmoim.module.business.service.BusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
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
    public HttpEntity<?> getBusinessList(){
        log.info("카테고리 리스트를 가져옵니다.");
        return businessService.businessList();
    }
}
