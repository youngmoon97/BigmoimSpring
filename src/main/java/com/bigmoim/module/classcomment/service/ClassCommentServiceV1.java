package com.bigmoim.module.classcomment.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.common.exception.BadRequestException;
import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.classcomment.dto.ClassCommentDTO;
import com.bigmoim.module.classcomment.entity.ClassCommentEntity;
import com.bigmoim.module.classcomment.repository.ClassCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClassCommentServiceV1 {
    private final ClassCommentRepository classCommentRepository;

    // 클래스 댓글 작성
    @Transactional
    public HttpEntity<?> ccInsert(ClassCommentDTO.ReqBasic reqDto){

        classCommentRepository.ccInsert(reqDto.classCommentEntity());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("댓글 작성 완료")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public HttpEntity<?> ccUpdate(CustomUserDetails customUserDetails, ClassCommentDTO.ReqBasic reqDto){

        ClassCommentEntity classCommentEntity = classCommentRepository.findByMemberId(reqDto.getCcNum());

        if(!classCommentEntity.getMemberId().equals(customUserDetails.getMemberEntity().getMemberId())){
            throw new BadRequestException("잘못된 요청 입니다.");
        }

        classCommentEntity.setUpdate(reqDto.getCcComment());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("댓글 수정 성공")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public HttpEntity<?> ccDelete(CustomUserDetails customUserDetails, Integer ccNum){
        ClassCommentEntity classCommentEntity = classCommentRepository.findByMemberId(ccNum);

        if(!classCommentEntity.getMemberId().equals(customUserDetails.getMemberEntity().getMemberId())){
            throw new BadRequestException("잘못된 요청 입니다.");
        }

        classCommentEntity.setDelete(ccNum);

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("댓글 삭제 성공")
                        .build(),
                HttpStatus.OK);
    }
}
