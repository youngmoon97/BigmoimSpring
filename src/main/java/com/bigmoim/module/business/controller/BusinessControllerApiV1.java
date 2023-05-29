package com.bigmoim.module.business.controller;

import com.bigmoim.module.business.service.BusinessService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/businessList")
public class BusinessControllerApiV1 {
    private BusinessService businessService;
    @GetMapping
    public HttpEntity<?> getBusinessList(){
        return businessService.businessList();
    }
}
