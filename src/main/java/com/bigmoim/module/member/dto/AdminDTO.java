package com.bigmoim.module.member.dto;

import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.moim.entity.MoimEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class AdminDTO {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResMember {

        private List<Member> memberList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Member {
            private String memberId;
            private String memberName;
            private String memberTel;
            private String memberProfile;
        }

        public static ResMember fromMemberEntity(List<MemberEntity> memberEntityList) {
            List<Member> memberList =  memberEntityList.stream().map(memberEntity -> {
                return Member.builder()
                        .memberId(memberEntity.getMemberId())
                        .memberName(memberEntity.getMemberName())
                        .memberTel(memberEntity.getMemberTel())
                        .memberProfile(memberEntity.getMemberProfile())
                        .build();
            }).collect(Collectors.toList());
            return new ResMember(memberList);
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResMoim {

        private List<Moim> moimList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Moim {
            private Integer moimNum;
            private String moimName;
            private String memberId; //회장아이디
            private String moimDate; //개설일자
        }

        public static ResMoim fromMoimEntity(List<MoimEntity> moimEntityList) {
            List<Moim> moimList = moimEntityList.stream().map(moimEntity -> {
                return Moim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .memberId(moimEntity.getMemberId())
                        .moimDate(moimEntity.getMoimDate())
                        .build();
            }).collect(Collectors.toList());
            return new ResMoim(moimList);
        }
    }
}