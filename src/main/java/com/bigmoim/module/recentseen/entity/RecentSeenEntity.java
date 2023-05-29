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
    private Integer resentseenNum;
    private String memberId;
    private Integer moimNum;
    private LocalDateTime rsDate;
}
