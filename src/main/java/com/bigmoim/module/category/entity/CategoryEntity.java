package com.bigmoim.module.category.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    private int categoryNum;
    private String categoryName;
    private String categoryImg;
    @Override
    public String toString() {
        return "CategoryEntity [categoryNum=" + categoryNum + ", categoryName=" + categoryName + ", categoryImg=" + categoryImg + "]";
    }
}
