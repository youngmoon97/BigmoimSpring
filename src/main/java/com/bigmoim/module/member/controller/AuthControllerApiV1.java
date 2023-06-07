package com.bigmoim.module.member.controller;

import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.member.service.AuthService;
import com.bigmoim.module.member.service.AuthServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {

    private final AuthService authService;
    private final AuthServiceApiV1 authServiceApiV1;

    @PostMapping("/signup")
    public HttpEntity<?> signupProc(AuthDTO.ReqJoin reqDto, @RequestParam("file") List<MultipartFile> multipartFileList){
        System.out.println(multipartFileList);

        return authServiceApiV1.signupProc(reqDto, multipartFileList);
    }

    @PostMapping("/findId")
    public HttpEntity<?> findIdProc(@Validated @RequestBody AuthDTO.ReqJoin reqDto){
        return authServiceApiV1.findIdProc(reqDto);
    }

    @PostMapping("/signup/checkId/{id}")
    public Integer checkId(@PathVariable String id){
        return authService.checkId(id);
    }

}
