package com.bigmoim.module.moim.dto;

import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.moim.entity.MoimEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class MainDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<Class> classList;
        private List<AllMoim> allMoimList;
        private Member member;
        private List<Role> roleList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Member{
            private String memberId;
            private String memberImg;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Role{
            private String memberId;
            private String role;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Class {
            int moimNum;
            String moimName;
            String moimArea;
            int moimHCount;
            int moimNCount;
            String memberId;
            String moimKakao;
            int categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            int businessNum;
            int taskNum;
            int themeNum;
            String classPrice;
            int moimOrClass;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AllMoim {
            int moimNum;
            String moimName;
            String moimArea;
            int moimHCount;
            int moimNCount;
            String memberId;
            String moimKakao;
            int categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            int businessNum;
            int taskNum;
            int themeNum;
            String classPrice;
            int moimOrClass;
        }

        public static ResBasic fromEntityList(List<MoimEntity> moimEntityList, List<MoimEntity> allMoimEntityList,MemberEntity memberEntity,List<RoleEntity> roleEntityList) {

            List<Class> classList = moimEntityList.stream().map(moimEntity -> {
                return Class.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());

            List<AllMoim> allMoimList = allMoimEntityList.stream().map(moimEntity -> {
                return AllMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());

            Member member = Member.builder()
                    .memberId(memberEntity.getMemberId())
                    .memberImg(memberEntity.getMemberImg())
                    .build();

            List<Role> roleList = roleEntityList.stream().map(role -> {
                return Role.builder()
                        .memberId(role.getMemberId())
                        .role(role.getRole())
                        .build();
            }).collect(Collectors.toList());

            return new ResBasic(classList,allMoimList,member,roleList);
        }
    }
}
