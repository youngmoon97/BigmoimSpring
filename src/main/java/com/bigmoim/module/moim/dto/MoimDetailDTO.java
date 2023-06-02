package com.bigmoim.module.moim.dto;

import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.moim.entity.MoimEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MoimDetailDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResMoimDetail {

        private MoimDetail moimDetail;
        private MainDTO.ResBasic.Member member;
        private List<Role> roleList;

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
        public static class Role {
            private String memberId;
            private String role;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MoimDetail {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            LocalDateTime moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        public static ResMoimDetail toMoimDetail(MoimEntity moimEntity,
                                                 MemberEntity memberEntity,
                                                 List<RoleEntity> roleEntityList) {
            MoimDetail moimDetail1 = MoimDetail.builder()
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
            MainDTO.ResBasic.Member member = MainDTO.ResBasic.Member.builder()
                    .memberId(memberEntity.getMemberId())
                    .memberImg(memberEntity.getMemberImg())
                    .build();

            List<Role> roleList = roleEntityList.stream().map(role -> {
                return Role.builder()
                        .memberId(role.getMemberId())
                        .role(role.getRole())
                        .build();
            }).collect(Collectors.toList());

            return new ResMoimDetail(moimDetail1,member,roleList);
        }
    }
}
