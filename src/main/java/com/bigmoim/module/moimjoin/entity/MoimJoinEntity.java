package com.bigmoim.module.moimjoin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoimJoinEntity {
    private int mjNum;
    private int moimNum;
    private String memberId;
    private int mjCheck;	//가입승인
    private String mjDate;
    private String mjContent;
}
