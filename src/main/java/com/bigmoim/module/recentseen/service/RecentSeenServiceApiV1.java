package com.bigmoim.module.recentseen.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.jjimlist.repository.JjimListRepository;
import com.bigmoim.module.recentseen.dto.RecentSeenDTO;
import com.bigmoim.module.recentseen.repository.RecentSeenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecentSeenServiceApiV1 {
    private final RecentSeenRepository recentSeenRepository;

    //최근 본 모임 확인
    public HttpEntity<?> rsList(String memberId) {
        recentSeenRepository.rsList(memberId);

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("최근 본 모임 확인에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    //최근 본 모임 추가
    @Transactional
    public HttpEntity<?> rsInsert(RecentSeenDTO.ReqBasic reqDto){
        recentSeenRepository.rsInsert(reqDto.getMemberId(), reqDto.getMoimNum());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("최근 본 모임 추가에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    //최근 본 모임 시간 업데이트
    @Transactional
    public HttpEntity<?> rsUpdate(RecentSeenDTO.ReqBasic reqDto){
        recentSeenRepository.rsUpdate(reqDto.getMemberId(), reqDto.getMoimNum());

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("최근 본 모임 시간 업데이트에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }
}
