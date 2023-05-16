package com.bigmoim.module.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {
  private String adminId;
  private String adminPw;
  private String adminName;
  private String adminTel;
}
