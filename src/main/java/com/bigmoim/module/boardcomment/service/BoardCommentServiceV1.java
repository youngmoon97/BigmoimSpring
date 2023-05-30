package com.bigmoim.module.boardcomment.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.common.exception.BadRequestException;
import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.boardcomment.dto.BoardCommentDTO;
import com.bigmoim.module.boardcomment.entity.BoardCommentEntity;
import com.bigmoim.module.boardcomment.repository.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardCommentServiceV1 {
    private  final BoardCommentRepository boardCommentRepository;

    @Transactional
    public HttpEntity<?> bcInsert(BoardCommentDTO.ReqBasic reqDto){

        boardCommentRepository.bcInsert(reqDto.boardCommentEntity());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("댓글 등록 성공")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public HttpEntity<?> bcUpdate(CustomUserDetails customUserDetails,BoardCommentDTO.ReqBasic reqDto){
        BoardCommentEntity boardCommentEntity =  boardCommentRepository.findBcMemberId(reqDto.getBcNum());

        if(!boardCommentEntity.getMemberId().equals(customUserDetails.getMemberEntity().getMemberId())){
            throw new BadRequestException("잘못된 요청 입니다.");
        }

        boardCommentEntity.setUpdate(reqDto.getBcComment());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("댓글 수정 성공")
                        .build(),
                HttpStatus.OK
        );
    }

    @Transactional
    public HttpEntity<?> bcDelete(CustomUserDetails customUserDetails, Integer bcNum){
        BoardCommentEntity boardCommentEntity = boardCommentRepository.findBcMemberId(bcNum);

        if(!boardCommentEntity.getMemberId().equals(customUserDetails.getMemberEntity().getMemberId())){
            throw new BadRequestException("잘못된 요청 입니다.");
        }


        boardCommentRepository.bcDelete(bcNum);

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("댓글 삭제 성공")
                        .build(),
                HttpStatus.OK);
    }
}
