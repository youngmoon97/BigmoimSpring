package com.bigmoim.module.moim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoimEntity {
    private Integer moimNum;
    private String moimName;
    private String moimArea;
    private Integer moimHCount;
    private Integer moimNCount;
    private String memberId;
    private String moimKakao;
    private Integer categoryNum;
    private String moimImg;
    private String moimProfile;
    private LocalDateTime moimDate;
    private Integer businessNum;
    private Integer taskNum;
    private Integer themeNum;
    private String classPrice;
    private Integer moimOrClass;
}
