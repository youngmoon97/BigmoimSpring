package com.bigmoim.module.recentseen.controller;

import com.bigmoim.module.jjimlist.dto.JjimListDTO;
import com.bigmoim.module.jjimlist.service.JjimListServiceApiV1;
import com.bigmoim.module.recentseen.dto.RecentSeenDTO;
import com.bigmoim.module.recentseen.service.RecentSeenServiceApiV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/recentSeen")
public class RecentSeenControllerApiV1 {
    private RecentSeenServiceApiV1 recentSeenServiceApiV1;

    @GetMapping
    public HttpEntity<?> rsList(String memberId){
        log.info("최근 본 모임 확인을 요청합니다.");
        return recentSeenServiceApiV1.rsList(memberId);
    }

    @PostMapping
    public HttpEntity<?> rsInsert(@RequestBody RecentSeenDTO.ReqBasic reqDto){
        log.info("최근 본 모임 추가를 요청합니다.");
        return recentSeenServiceApiV1.rsInsert(reqDto);
    }

    @PutMapping
    public HttpEntity<?> rsUpdate(@RequestBody RecentSeenDTO.ReqBasic reqDto){
        log.info("최근 본 모임 시간 업데이트를 요청합니다.");
        return recentSeenServiceApiV1.rsUpdate(reqDto);
    }
}
