package com.bigmoim.module.jjimlist.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.jjimlist.dto.JjimListDTO;
import com.bigmoim.module.jjimlist.repository.JjimListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JjimListServiceApiV1 {
    private final JjimListRepository jjimListRepository;

    //찜목록 추가
    @Transactional
    public HttpEntity<?> jjimInsert(JjimListDTO.ReqBasic reqDto){
        jjimListRepository.jjimInsert(reqDto.getMemberId(), reqDto.getMoimNum());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("찜 목록 추가에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    //내 찜 여부 확인
    public HttpEntity<?> jjimCheck(JjimListDTO.ReqBasic reqDto) {
        jjimListRepository.jjimCheck(reqDto.getMemberId(), reqDto.getMoimNum());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("내 찜 여부 조회에 성공하였습니다.")
                        //.data()
                        .build(),
                HttpStatus.OK);
    }

    //찜목록 제거
    @Transactional
    public HttpEntity<?> jjimDelete(JjimListDTO.ReqBasic reqDto){
        jjimListRepository.jjimDelete(reqDto.getMemberId(), reqDto.getMoimNum());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("찜 목록 제거에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    //찜 개수 확인
    @Transactional
    public HttpEntity<?> jjimCount(Integer moimNum){
        jjimListRepository.jjimCount(moimNum);

        return new ResponseEntity(
                ResDTO.builder()
                        .code(0)
                        .message("찜 개수 확인에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    //내 찜목록 확인
    public HttpEntity<?> jjimList(String memberId) {
        jjimListRepository.jjimList(memberId);

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("내 찜목록 조회에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }
}
