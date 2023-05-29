package com.bigmoim.module.category.service;

import com.bigmoim.module.category.dto.CategoryDTO;
import com.bigmoim.module.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDTO.ResBasic getCategoryList(){
        return CategoryDTO.ResBasic.fromEntityList(categoryRepository.categoryList());
    }

//    public HttpEntity<?> categoryList() {
//        List<CategoryEntity> categoryEntityList = categoryRepository.categoryList();
//        return new ResponseEntity<>(
//                ResDTO.builder()
//                        .code(0)
//                        .message("카테고리 리스트 조회에 성공하였습니다.")
//                        .data(CategoryDTO.ResBasic.fromEntityList(categoryEntityList).getCategoryList())
//                        .build(),
//                HttpStatus.OK);
//    }
}
