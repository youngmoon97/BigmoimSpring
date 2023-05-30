package com.bigmoim.module.memberboard.controller;

import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.memberboard.dto.MemberboardDTO;
import com.bigmoim.module.memberboard.service.MemberBoardServiceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/memberboard")
public class MemberBoardControllerApiV1 {
    private MemberBoardServiceV1 memberBoardServiceV1;

    @PostMapping
    public HttpEntity<?> boardInsert(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Validated @RequestBody MemberboardDTO.ReqBasic reqDto)
    {
        log.info("게시판 등록 완료");

        return memberBoardServiceV1.boardInsert(reqDto);
    }

    @PutMapping// PathVariable대신에 reqDto 만들어서 가져오기
    public HttpEntity<?> boardUpdate(
            @AuthenticationPrincipal CustomUserDetails customUserDetails
            ,@RequestBody MemberboardDTO.ReqUpdate reqDto){
        log.info("게시판 수정 완료");
        return memberBoardServiceV1.boardUpdate(customUserDetails, reqDto);
    }

    @DeleteMapping("/{mbNum}")
    public HttpEntity<?> boardDelete(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @PathVariable Integer mbNum){
        log.info("게시판 삭제 완료");
        return memberBoardServiceV1.boardDelete(customUserDetails , mbNum);
    }
}
