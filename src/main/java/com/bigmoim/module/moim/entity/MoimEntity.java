package com.bigmoim.module.moim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoimEntity {
    private int moimNum;
    private String moimName;
    private String moimArea;
    private int moimHCount;
    private int moimNCount;
    private String memberId;
    private String moimKakao;
    private int categoryNum;
    private String moimImg;
    private String moimProfile;
    private String moimDate;
    private int businessNum;
    private int taskNum;
    private int themeNum;
    private String classPrice;
    private int moimOrClass;
}
