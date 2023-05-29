package com.bigmoim.module.theme.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.theme.dto.ThemeDTO;
import com.bigmoim.module.theme.entity.ThemeEntity;
import com.bigmoim.module.theme.repository.ThemeRepository;
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
public class ThemeService {

    private final ThemeRepository themeRepository;

    public ThemeDTO.ResBasic getThemeList(){
        return ThemeDTO.ResBasic.fromEntityList(themeRepository.themeList());
    }
//    public HttpEntity<?> themeList(){
//        List<ThemeEntity> themeEntityList = themeRepository.themeList();
//        return new ResponseEntity<>(
//                ResDTO.builder()
//                        .code(0)
//                        .message("테마 리스트 조회에 성공하였습니다.")
//                        .data(ThemeDTO.ResBasic.fromEntityList(themeEntityList).getThemeList())
//                        .build(),
//                HttpStatus.OK);
//    }
}
