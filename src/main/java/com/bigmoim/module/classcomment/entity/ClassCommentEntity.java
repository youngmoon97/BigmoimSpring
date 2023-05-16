package com.bigmoim.module.classcomment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassCommentEntity {
  private int ccNum;
  private String ccComment;
  private String ccDate;
  private String memberId;
  private int moimNum;
}
