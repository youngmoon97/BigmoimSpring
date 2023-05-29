package com.bigmoim.module.member.controller;

import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.member.service.AuthServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {

    private final AuthServiceApiV1 authServiceApiV1;
    @PostMapping("/signup")
    public HttpEntity<?> signupProc(@Validated @RequestBody AuthDTO.ReqJoin reqDto){
        return authServiceApiV1.signupProc(reqDto);
    }
    @PostMapping("/findId")
    public HttpEntity<?> findIdProc(@Validated @RequestBody AuthDTO.ReqJoin reqDto){
        return authServiceApiV1.findIdProc(reqDto);
    }
}
