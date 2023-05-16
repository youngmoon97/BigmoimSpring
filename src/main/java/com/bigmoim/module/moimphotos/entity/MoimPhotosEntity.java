package com.bigmoim.module.moimphotos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoimPhotosEntity {
  private int photoNum;
  private String photoName;
  private int moimNum;
  private String photo;
  private String upDate;
  private String memberId;
}
