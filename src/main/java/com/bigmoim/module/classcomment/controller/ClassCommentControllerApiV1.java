package com.bigmoim.module.classcomment.controller;

import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.classcomment.dto.ClassCommentDTO;
import com.bigmoim.module.classcomment.service.ClassCommentServiceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/classcomment")
public class ClassCommentControllerApiV1 {
    private ClassCommentServiceV1 classCommentServiceV1;

    // 댓글 작성

    @PostMapping
    public HttpEntity<?> ccInsert(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Validated @RequestBody ClassCommentDTO.ReqBasic reqDto){
        log.info("댓글 작성 완료");
        return classCommentServiceV1.ccInsert(reqDto);
    }


    @PutMapping
    public HttpEntity<?> ccUpdate(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Validated @RequestBody ClassCommentDTO.ReqBasic reqDto
    ){
        log.info("댓글 수정 완료");
        return classCommentServiceV1.ccUpdate(customUserDetails,reqDto);
    }

    @DeleteMapping("/{ccNum}")
    public HttpEntity<?> ccDelete(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @PathVariable Integer ccNum
    ){
        return classCommentServiceV1.ccDelete(customUserDetails, ccNum);
    }
}
