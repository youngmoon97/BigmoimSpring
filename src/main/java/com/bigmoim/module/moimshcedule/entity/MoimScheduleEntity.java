package com.bigmoim.module.moimshcedule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoimScheduleEntity {
    private int msNum;
    private String msTime;
    private String msArea;
    private int moimNum;
    private int msHCount;
    private String memberId;
    private int msNCount;
    private String msTitle;
    private String msContent;
    private String msDate;
    private String moimImg;
}
