package com.bigmoim.module.category.dto;

import com.bigmoim.module.category.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<Category> categoryList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Category {
            int categoryNum;
            String categoryName;
            String categoryImg;
        }
        public static ResBasic fromEntityList(List<CategoryEntity> categoryEntityList){
            List<Category> categoryList =  categoryEntityList.stream().map(categoryEntity -> {
//                return Category(1, "자기계발","ㅁㄴㅇ");
                return Category.builder()
                        .categoryNum(categoryEntity.getCategoryNum())
                        .categoryName(categoryEntity.getCategoryName())
                        .categoryImg(categoryEntity.getCategoryImg())
                        .build();
            }).collect(Collectors.toList());
            return new ResBasic(categoryList);
        }
    }
}
