package com.bigmoim.module.classcomment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassCommentEntity {
  private int ccNum;
  private String ccComment;
  private String memberId;
  private int moimNum;
  private Date ccDate;
}
