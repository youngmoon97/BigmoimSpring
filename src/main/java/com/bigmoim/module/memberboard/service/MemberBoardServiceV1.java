package com.bigmoim.module.memberboard.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.memberboard.dto.MemberboardDTO;
import com.bigmoim.module.memberboard.entity.MemberBoardEntity;
import com.bigmoim.module.memberboard.repository.MemberBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class MemberBoardServiceV1 {
    private final MemberBoardRepository memberBoardRepository;

    @Transactional
    public HttpEntity<?> boardInsert(MemberboardDTO.ReqBasic reqDto){
        memberBoardRepository.boardInsert(reqDto.boardEntity());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("게시글 등록에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public HttpEntity<?> boardUpdate(MemberboardDTO.ReqBasic reqDto){
        memberBoardRepository.boardUpdate(reqDto.getMemberId());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("게시글 수정하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public HttpEntity<?> boardDelete(MemberboardDTO.ReqBasic reqDto){
        memberBoardRepository.boardDelete(reqDto.getMemberId());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("게시글 삭제하였습니다.")
                        .build(),
                HttpStatus.OK);
    }
}

