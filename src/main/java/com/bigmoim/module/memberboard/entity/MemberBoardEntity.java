package com.bigmoim.module.memberboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberBoardEntity {
    private int mbNum;
    private String mbTitle;
    private String mbContent;
    private LocalDateTime mbDate;
    private String memberId;
    private String mbImg;
    private int moimNum;
    private String boardType;

    // 게시글 업데이트
    public void setUpdate(String meTitle, String mbContent, String mbImg){
        this.mbTitle = mbTitle;
        this.mbContent = mbContent;
        this.mbImg = mbImg;
    }
    // 게시글 삭제
    public void setDelete(String memberId){
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberBoardEntity{" +
                "mbNum=" + mbNum +
                ", mbTitle='" + mbTitle + '\'' +
                ", mbContent='" + mbContent + '\'' +
                ", mbDate='" + mbDate + '\'' +
                ", memberId='" + memberId + '\'' +
                ", mbImg='" + mbImg + '\'' +
                ", moimNum=" + moimNum +
                ", boardType='" + boardType + '\'' +
                '}';
    }
}
