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
    private Integer sjNum;
    private String memberid;
    private Integer moimNum;
    private Integer msNum;
}
