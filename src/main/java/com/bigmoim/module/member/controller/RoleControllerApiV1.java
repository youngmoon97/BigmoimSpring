//package com.bigmoim.module.member.controller;
//
//import com.bigmoim.module.member.entity.RoleEntity;
//import com.bigmoim.module.member.service.RoleServiceApiV1;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpEntity;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/role")
//public class RoleControllerApiV1 {
//    private RoleServiceApiV1 roleServiceApiV1;
//
//    @GetMapping
//    public HttpEntity<?> findById(String memberId){
//        log.info("역할 찾기를 요청합니다.");
//        return roleServiceApiV1.findById(memberId);
//    }
//
//    @GetMapping
//    public HttpEntity<?> findByRole(String role){
//        log.info("역할별 리스트 찾기를 요청합니다.");
//        return roleServiceApiV1.findByRole(role);
//    }
//
//    @DeleteMapping
//    public HttpEntity<?> roleDelete(String memberId, String role){
//        log.info("역할을 제거합니다.");
//        return roleServiceApiV1.roleDelete(memberId, role);
//    }
//
//    @PostMapping
//    public HttpEntity<?> roleInsert(RoleEntity roleEntity){
//        log.info("역할을 추가합니다.");
//        return  roleServiceApiV1.roleInsert(roleEntity);
//    }
//}
