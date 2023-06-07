package com.bigmoim.module.moimshcedule.dto;

import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.moimshcedule.entity.MoimScheduleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class MoimScheduleDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResMoimSchedule {
        List<MoimSchedule> allMoimScheduleList;
        Member member;
        List<Category> categoryList;
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Category {
            private Integer categoryNum;
            private String categoryName;
            private String categoryImg;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Member {
            private String memberId;
            private String memberImg;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Moim {
            private Integer moimNum;
            private String moimImg;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MoimSchedule {
            private int msNum;
            private String msTime;
            private String msArea;
            private List<Moim> moimList;
            private int msHCount;
            private String memberId;
            private int msNCount;
            private String msTitle;
            private String msContent;
            private String msDate;
            private List<Member> memberList;
        }
        public static ResMoimSchedule fromEntityList(
                MemberEntity memberEntity,
                List<MoimScheduleEntity> allMoimScheduleEntityList,
                List<CategoryEntity> categoryEntityList,
                List<MoimEntity> moimEntityList,
                List<MemberEntity> memberEntityList) {

            Member member1 = Member.builder()
                    .memberId(memberEntity.getMemberId())
                    .memberImg(memberEntity.getMemberImg())
                    .build();

            List<MoimSchedule> allMoimScheduleList = allMoimScheduleEntityList.stream().map(moimSchedule -> {
                        return MoimSchedule.builder()
                                .msNum(moimSchedule.getMsNum())
                                .moimList(
                                        moimEntityList.stream().filter(
                                                moimEntity -> moimEntity.getMoimNum().equals(moimSchedule.getMoimNum())
                                        ).map(moimEntity -> {
                                            return Moim.builder()
                                                    .moimNum(moimEntity.getMoimNum())
                                                    .moimImg(moimEntity.getMoimImg())
                                                    .build();
                                        }).collect(Collectors.toList())
                                )
                                .msHCount(moimSchedule.getMsHCount())
                                .memberId(moimSchedule.getMemberId())
                                .msArea(moimSchedule.getMsArea())
                                .msTitle(moimSchedule.getMsTitle())
                                .msContent(moimSchedule.getMsContent())
                                .msDate(moimSchedule.getMsDate())
                                .msNCount(moimSchedule.getMsNCount())
                                .msTime(moimSchedule.getMsTime())
                                .memberList(
                                        memberEntityList.stream().filter(memberEntity1 ->
                                                memberEntity1.getMemberId().equals(moimSchedule.getMemberId())
                                        ).map(memberEntity1 -> {
                                            return Member.builder()
                                                    .memberId(memberEntity1.getMemberId())
                                                    .memberImg(memberEntity1.getMemberImg())
                                                    .build();
                                                }).collect(Collectors.toList())
                                )
                                .build();
                    }).collect(Collectors.toList());

            List<Category> categoryList = categoryEntityList.stream().map(categoryEntity -> {
                return Category.builder()
                        .categoryNum(categoryEntity.getCategoryNum())
                        .categoryName(categoryEntity.getCategoryName())
                        .categoryImg(categoryEntity.getCategoryImg())
                        .build();
            }).collect(Collectors.toList());
            return new ResMoimSchedule(allMoimScheduleList,member1,categoryList);

        }
    }
}
