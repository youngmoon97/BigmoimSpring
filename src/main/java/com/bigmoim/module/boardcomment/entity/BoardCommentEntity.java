package com.bigmoim.module.boardcomment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardCommentEntity {
  private int bcNum;
  private String bcContent;
  private String memberId;
  private String bcDate;
  private int mbNum;
}
