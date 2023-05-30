package com.bigmoim.module.boardcomment.contorller;

import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.boardcomment.dto.BoardCommentDTO;
import com.bigmoim.module.boardcomment.service.BoardCommentService;
import com.bigmoim.module.boardcomment.service.BoardCommentServiceV1;
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
@RequestMapping("api/v1/boardcomment")
public class BoardCommentControllerApiV1 {
    private BoardCommentServiceV1 boardCommentServiceV1;
    
    // 댓글 작성
    @PostMapping
    public HttpEntity<?> bcInsert(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Validated @RequestBody BoardCommentDTO.ReqBasic reqDto) {
        log.info("댓글 등록 완료");
        return boardCommentServiceV1.bcInsert(reqDto);
    }

    // 댓글 수정
    @PutMapping
    public HttpEntity<?> bcUpdate(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Validated @RequestBody BoardCommentDTO.ReqBasic reqDto
    ){
        log.info("댓글 수정 완료");
        return boardCommentServiceV1.bcUpdate(customUserDetails, reqDto);
    }
    
    // 댓글 삭제
    @DeleteMapping("/{bcNum}")
    public HttpEntity<?> bcDelete(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @PathVariable Integer bcNum
    ){
        log.info("댓글 삭제 완료");
        return boardCommentServiceV1.bcDelete(customUserDetails, bcNum);
    }
    
}
