package com.bigmoim.module.category.controller;

import com.bigmoim.module.category.service.CategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/categoryList")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public HttpEntity<?> getCategoryList(){
        log.info("카테고리 리스트를 가져옵니다.");
        return categoryService.categoryList();
    }

}
