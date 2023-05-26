package com.bigmoim.module.moim.controller;

import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.moim.service.MoimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/moim")
public class MoimController {
    private final MoimService moimService;

    @GetMapping
    public HttpEntity<?> allMoim(){
        log.info("모든 모임 리스트를 가져옵니다.");
        return moimService.allMoim();
    }

    @GetMapping
    public HttpEntity<?> findByMoimNum(int moimNum){
        log.info("모임 번호로 모임을 가져옵니다.");
        return moimService.findByMoimNum(moimNum);
    }

    @GetMapping
    public HttpEntity<?> myMoimList(String memberId){
        log.info("내 모임 리스트를 가져옵니다.");
        return moimService.myMoimList(memberId);
    }

    @GetMapping
    public HttpEntity<?> searchMoimList(String moimName){
        log.info("모임을 검색합니다.");
        return moimService.searchMoimList(moimName);
    }

    @GetMapping
    public HttpEntity<?> classList(){
        log.info("클래스 리스트를 가져옵니다.");
        return moimService.classList();
    }

    @GetMapping
    public HttpEntity<?> businessList(int businessNum){
        log.info("업종별 모임 리스트를 가져옵니다.");
        return moimService.businessList(businessNum);
    }

    @GetMapping
    public HttpEntity<?> taskList(int taskNum){
        log.info("직무별 모임 리스트를 가져옵니다.");
        return moimService.taskList(taskNum);
    }

    @GetMapping
    public HttpEntity<?> themeList(int themeNum){
        log.info("테마 모임 리스트를 가져옵니다.");
        return moimService.themeList(themeNum);
    }

    @GetMapping
    public HttpEntity<?> areaList(String moimArea){
        log.info("지역별 모임 리스트를 가져옵니다.");
        return moimService.areaList(moimArea);
    }

    @PostMapping
    public HttpEntity<?> moimInsert(MoimEntity moimEntity){
        log.info("모임을 생성합니다.");
        return moimService.moimInsert(moimEntity);
    }

    @PutMapping
    public HttpEntity<?> moimUpdate(int moimNum){
        log.info("모임을 수정합니다.");
        return moimService.moimUpdate(moimNum);
    }

    @DeleteMapping
    public HttpEntity<?> moimDelete(int moimNum){
        log.info("모임을 제거합니다.");
        return moimService.moimDelete(moimNum);
    }
}
