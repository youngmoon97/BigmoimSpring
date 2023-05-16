package com.bigmoim.module.memberboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberBoardEntity {
    private int mbNum;
    private String mbTitle;
    private String mbContent;
    private String mbDate;
    private String memberId;
    private String mbImg;
    private int moimNum;
    private String boardType;
}
