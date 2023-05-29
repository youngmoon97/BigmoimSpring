package com.bigmoim.module.memberboard.controller;

import com.bigmoim.module.memberboard.dto.MemberboardDTO;
import com.bigmoim.module.memberboard.service.MemberBoardServiceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.HttpEntity;
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
    public HttpEntity<?> boardInsert(@Validated @RequestBody MemberboardDTO.ReqBasic reqDto)
    {
        log.info("게시판 등록 완료");

        return memberBoardServiceV1.boardInsert(reqDto);
    }

    @PutMapping("/{memberId}")
    public HttpEntity<?> boardUpdate(@Validated @RequestBody MemberboardDTO.ReqBasic reqDto){

        return memberBoardServiceV1.boardUpdate(reqDto);
    }

    @DeleteMapping("/{memberId}")
    public HttpEntity<?> boardDelete(@Validated @RequestBody MemberboardDTO.ReqBasic reqDto){
        return memberBoardServiceV1.boardDelete(reqDto);
    }
}
