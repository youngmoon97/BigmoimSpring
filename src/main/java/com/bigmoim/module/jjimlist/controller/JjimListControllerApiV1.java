package com.bigmoim.module.jjimlist.controller;

import com.bigmoim.module.category.dto.CategoryDTO;
import com.bigmoim.module.jjimlist.dto.JjimListDTO;
import com.bigmoim.module.jjimlist.service.JjimListServiceApiV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jjimList")
public class JjimListControllerApiV1 {
    private JjimListServiceApiV1 jjimListServiceApiV1;

    @PostMapping
    public HttpEntity<?> jjimInsert(@RequestBody JjimListDTO.ReqBasic reqDto){
        log.info("찜목록 추가를 요청합니다.");
        return jjimListServiceApiV1.jjimInsert(reqDto);
    }

    @GetMapping
    public HttpEntity<?> jjimCheck(@RequestBody JjimListDTO.ReqBasic reqDto){
        log.info("찜 여부 확인을 요청합니다.");
        return jjimListServiceApiV1.jjimCheck(reqDto);
    }

    @DeleteMapping
    public HttpEntity<?> jjimDelete(@RequestBody JjimListDTO.ReqBasic reqDto){
        log.info("찜목록 삭제를 요청합니다.");
        return jjimListServiceApiV1.jjimDelete(reqDto);
    }

    @GetMapping("/{moimNum}")
    public HttpEntity<?> jjimCount(Integer moimNum){
        log.info("모임의 찜 개수를 확인합니다.");
        return jjimListServiceApiV1.jjimCount(moimNum);
    }

    @GetMapping("/{memberId}")
    public HttpEntity<?> jjimList(String memberId){
        log.info("찜목록 확인을 요청합니다.");
        return jjimListServiceApiV1.jjimList(memberId);
    }
}
