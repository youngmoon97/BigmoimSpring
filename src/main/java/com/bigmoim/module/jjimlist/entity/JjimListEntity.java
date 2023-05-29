package com.bigmoim.module.jjimlist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JjimListEntity {
  private Integer jjimNum;
  private String memberId;
  private Integer moimNum;
}
