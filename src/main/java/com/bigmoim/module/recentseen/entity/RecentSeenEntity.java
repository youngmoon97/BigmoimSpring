package com.bigmoim.module.recentseen.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecentSeenEntity {
    private int resentseenNum;
    private String memberId;
    private int moimNum;
    private LocalDateTime rsDate;
}
