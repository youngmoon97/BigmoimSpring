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
  private int jjimNum;
  private String memberId;
  private int moimNum;
}
