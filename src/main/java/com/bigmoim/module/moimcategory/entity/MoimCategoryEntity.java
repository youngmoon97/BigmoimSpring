package com.bigmoim.module.moimcategory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoimCategoryEntity {
  private int categoryNum;
  private String categoryName;
  private String categoryImg;
}
