package com.bigmoim.module.moimmember.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoimMemberEntity {
  private int mmNum;
  private String memberId;
  private int moimNum;
}
