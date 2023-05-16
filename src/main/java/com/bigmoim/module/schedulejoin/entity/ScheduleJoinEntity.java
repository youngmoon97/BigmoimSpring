package com.bigmoim.module.schedulejoin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleJoinEntity {
    private int sjNum;
    private String memberid;
    private int moimNum;
    private int msNum;
}
