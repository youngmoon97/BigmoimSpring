package com.bigmoim.module.category.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.category.dto.CategoryDTO;
import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public HttpEntity<?> categoryList() {
        List<CategoryEntity> categoryEntityList = categoryRepository.categoryList();
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("카테고리 리스트 조회에 성공하였습니다.")
                        .data(CategoryDTO.ResBasic.fromEntityList(categoryEntityList).getCategoryList())
                        .build(),
                HttpStatus.OK);
    }
}
