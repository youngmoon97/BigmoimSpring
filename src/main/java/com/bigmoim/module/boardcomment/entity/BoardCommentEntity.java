package com.bigmoim.module.boardcomment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardCommentEntity {
  private int bcNum;
  private String bcContent;
  private String memberId;
  private LocalDateTime bcDate;
  private int mbNum;

  public void setUpdate(String bcContent){
    this.bcContent = bcContent;
  }

  public void setDelete(Integer bcNum){
    this.bcNum = bcNum;
  }

  @Override
  public String toString() {
    return "BoardCommentEntity{" +
            "bcNum=" + bcNum +
            ", bcContent='" + bcContent + '\'' +
            ", memberId='" + memberId + '\'' +
            ", bcDate=" + bcDate +
            ", mbNum=" + mbNum +
            '}';
  }
}

