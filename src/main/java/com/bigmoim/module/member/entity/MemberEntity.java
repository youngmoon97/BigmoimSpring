package com.bigmoim.module.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberTel;
    private String memberBirth;
    private String memberImg;
    private String memberProfile;
    private int memberGender;	//남자=1, 여자=2
    private String memberAddr;
    private String memberJobAddr;
    private String memberLikeArea;
    private int categoryNum;
    private int businessNum;
    private int taskNum;
    private int themeNum;

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel;
    }

    public void setMemberBirth(String memberBirth) {
        this.memberBirth = memberBirth;
    }

    public void setMemberImg(String memberImg) {
        this.memberImg = memberImg;
    }

    public void setMemberProfile(String memberProfile) {
        this.memberProfile = memberProfile;
    }

    public void setMemberSex(int memberGender) {
        this.memberGender = memberGender;
    }

    public void setMemberAddr(String memberAddr) {
        this.memberAddr = memberAddr;
    }

    public void setMemberJobAddr(String memberJobAddr) {
        this.memberJobAddr = memberJobAddr;
    }

    public void setMemberLikeArea(String memberLikeArea) {
        this.memberLikeArea = memberLikeArea;
    }

    public void setCategoryNum(int categoryNum) {
        this.categoryNum = categoryNum;
    }

    public void setBusinessNum(int businessNum) {
        this.businessNum = businessNum;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }

    public void setThemeNum(int themeNum) {
        this.themeNum = themeNum;
    }
}
