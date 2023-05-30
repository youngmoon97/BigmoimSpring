package com.bigmoim.module.classcomment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
  private LocalDateTime ccDate;

  public void setUpdate(String ccComment){
    this.ccComment = ccComment;
  }

  public void setDelete(Integer ccNum){
    this.ccNum = ccNum;
  }

  @Override
  public String toString() {
    return "ClassCommentEntity{" +
            "ccNum=" + ccNum +
            ", ccComment='" + ccComment + '\'' +
            ", memberId='" + memberId + '\'' +
            ", moimNum=" + moimNum +
            ", ccDate=" + ccDate +
            '}';
  }
}




