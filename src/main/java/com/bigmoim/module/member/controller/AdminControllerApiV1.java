package com.bigmoim.module.member.controller;

import com.bigmoim.module.member.service.AdminService;
import com.bigmoim.module.member.service.RoleServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminControllerApiV1 {

    private final AdminService adminService;
    private final RoleServiceApiV1 roleServiceApiV1;

    //모임삭제
    @DeleteMapping("/deleteMoim/{moimNum}")
    public HttpEntity<?> moimDelete(@PathVariable Integer moimNum){
        return adminService.moimDelete(moimNum);
    }

    //회원의 모든 권한 삭제
    @DeleteMapping("/deleteAllRole/{memberId}")
    public HttpEntity<?> roleDeleteAll(@PathVariable String memberId){
        return roleServiceApiV1.roleDeleteAll(memberId);
    }

    //회원추방
    @DeleteMapping("/deleteMember/{memberId}")
    public HttpEntity<?> deleteMember(@PathVariable String memberId){
        return adminService.deleteMember(memberId);
    }
}
