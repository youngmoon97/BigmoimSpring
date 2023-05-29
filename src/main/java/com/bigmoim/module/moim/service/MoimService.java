package com.bigmoim.module.moim.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.moim.dto.MoimDTO;
import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.moim.repository.MoimRepository;
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
public class MoimService {
    private final MoimRepository moimRepository;

    public MoimDTO.ResBasic getClassList(){
        List<MoimEntity> classList = moimRepository.classList();
        return MoimDTO.ResBasic.fromEntityList(classList);
    }
    public HttpEntity<?> allMoim(){
        List<MoimEntity> moimEntityList = moimRepository.allMoim();
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모든 모임 리스트 조회에 성공하였습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(moimEntityList).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> findByMoimNum(int moimNum){
        MoimEntity findByMoimNumEntity = moimRepository.findByMoimNum(moimNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모임 번호로 모임을 찾았습니다.")
                        .data(findByMoimNumEntity)
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> myMoimList(String memberId){
        List<MoimEntity> myMoimListEntity = moimRepository.myMoimList(memberId);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("내 모임 리스트를 찾았습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(myMoimListEntity).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> searchMoimList(String moimName){
        List<MoimEntity> searchMoimEntityList = moimRepository.searchMoimList(moimName);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("검색한 모임을 찾았습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(searchMoimEntityList).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> classList(){
        List<MoimEntity> classEntityList = moimRepository.classList();
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("클래스 리스트 조회에 성공하였습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(classEntityList).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> businessList(int businessNum){
        List<MoimEntity> businessEntityList = moimRepository.businessList(businessNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("업종별 모임 리스트 조회에 성공하였습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(businessEntityList).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> taskList(int taskNum){
        List<MoimEntity> taskEntityList = moimRepository.taskList(taskNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("직무별 모임 리스트 조회에 성공하였습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(taskEntityList).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> themeList(int themeNum){
        List<MoimEntity> themeEntityList = moimRepository.themeList(themeNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("테마별 모임 리스트 조회에 성공하였습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(themeEntityList).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> categoryList(int categoryNum){
        List<MoimEntity> categoryEntityList = moimRepository.themeList(categoryNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("카테고리별 모임 리스트 조회에 성공하였습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(categoryEntityList).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> areaList(String moimArea){
        List<MoimEntity> areaEntityList = moimRepository.areaList(moimArea);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("지역별 모임 조회에 성공하였습니다.")
                        .data(MoimDTO.ResBasic.fromEntityList(areaEntityList).getMoimList())
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> moimInsert(MoimEntity moimEntity){
        Integer moimInsertResult = moimRepository.moimInsert(moimEntity);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모임을 생성했습니다.")
                        .data(moimInsertResult)
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> moimUpdate(int moimNum){
        Integer moimUpdateResult = moimRepository.moinUpdate(moimNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모임정보를 수정했습니다.")
                        .data(moimUpdateResult)
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> moimDelete(int moimNum){
        Integer moimDeleteResult = moimRepository.moimDelete(moimNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모임을 제거했습니다.")
                        .data(moimDeleteResult)
                        .build(),
                HttpStatus.OK);
    }

}
