package com.bigmoim.module.memberboard.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.common.exception.BadRequestException;
import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.memberboard.dto.MemberboardDTO;
import com.bigmoim.module.memberboard.entity.MemberBoardEntity;
import com.bigmoim.module.memberboard.repository.MemberBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public HttpEntity<?> boardUpdate(CustomUserDetails customUserDetails, MemberboardDTO.ReqUpdate reqDto){
        MemberBoardEntity memberBoardEntity = memberBoardRepository.findByMemberId(reqDto.getMbNum());
        if(!memberBoardEntity.getMemberId().equals(customUserDetails.getMemberEntity().getMemberId())){
            throw new BadRequestException("잘못된 요청 입니다.");
        }

        memberBoardEntity.setUpdate(reqDto.getMbTitle(), reqDto.getMbContent(),"img");

        memberBoardRepository.boardUpdate(memberBoardEntity);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("게시글 수정하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public HttpEntity<?> boardDelete(CustomUserDetails customUserDetails, Integer mbNum){
        MemberBoardEntity memberBoardEntity = memberBoardRepository.findByMemberId(mbNum);
        if(!memberBoardEntity.getMemberId().equals(customUserDetails.getMemberEntity().getMemberId())){
            throw new BadRequestException("잘못된 요청 입니다.");
        }
        memberBoardRepository.boardDelete( mbNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("게시글 삭제하였습니다.")
                        .build(),
                HttpStatus.OK);
    }
}

