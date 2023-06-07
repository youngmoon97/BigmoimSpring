package com.bigmoim.module.moim.dto;

import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.moimshcedule.entity.MoimScheduleEntity;
import com.bigmoim.module.schedulejoin.entity.ScheduleJoinEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoimDetailDTO {
//    @Data
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class ReqMoimDetail {
//        // 가입
//        // 탈퇴
//        // 일정참여
//        // 내모임관리
//        // 모임회원관리
//    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResMoimDetail {

        private MoimDetail moimDetail;
        private Member member;
        private List<Role> roleList;
        private List<Role> moimMemberList;
        private List<ScheduleJoin> scheduleJoinList;
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
        public static class Category {
            private Integer categoryNum;
            private String categoryName;
            private String categoryImg;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Role {
            private String memberId;
            private String role;
            private Integer moimNum;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ScheduleJoin {
            private Integer sjNum;
            private List<Member> memberList;
            private Integer moimNum;
            private Integer msNum;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MoimSchedule {
            private int msNum;
            private String msTime;
            private String msArea;
            private int moimNum;
            private int msHCount;
            private String memberId;
            private int msNCount;
            private String msTitle;
            private String msContent;
            private String msDate;
            private List<Member> memberList;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MoimDetail {
            private Integer moimNum;
            private String moimName;
            private String moimArea;
            private Integer moimHCount;
            private Integer moimNCount;
            private String memberId;
            private String moimKakao;
            private Category category;
            private String moimImg;
            private String moimProfile;
            private LocalDateTime moimDate;
            private Integer businessNum;
            private Integer taskNum;
            private Integer themeNum;
            private String classPrice;
            private Integer moimOrClass;
            private List<MoimSchedule> moimScheduleList;
        }

        public static ResMoimDetail toMoimDetail(
                MoimEntity moimEntity,
                MemberEntity memberEntity,
                List<MemberEntity> memberEntityList,
                List<RoleEntity> roleEntityList,
                List<RoleEntity> moimMemberEntityList,
                List<MoimScheduleEntity> moimScheduleEntityList,
                List<ScheduleJoinEntity> scheduleJoinEntityList,
                List<CategoryEntity> categoryEntityList
        ) {
            Optional<CategoryEntity> optionalCategoryEntity = categoryEntityList.stream().filter(categoryEntityForFilter ->
                    categoryEntityForFilter.getCategoryNum().equals(moimEntity.getCategoryNum())
            ).findFirst();

            MoimDetail moimDetail1 = MoimDetail.builder()
                    .moimNum(moimEntity.getMoimNum())
                    .moimName(moimEntity.getMoimName())
                    .moimArea(moimEntity.getMoimArea())
                    .moimHCount(moimEntity.getMoimHCount())
                    .moimNCount(moimEntity.getMoimNCount())
                    .memberId(moimEntity.getMemberId())
                    .moimKakao(moimEntity.getMoimKakao())
                    .category(
                            Category.builder()
                                    .categoryNum(moimEntity.getCategoryNum())
                                    .categoryName(optionalCategoryEntity.get().getCategoryName())
                                    .categoryImg(optionalCategoryEntity.get().getCategoryImg())
                                    .build()
                    )
                    .moimImg(moimEntity.getMoimImg())
                    .moimProfile(moimEntity.getMoimProfile())
                    .moimDate(moimEntity.getMoimDate())
                    .businessNum(moimEntity.getBusinessNum())
                    .taskNum(moimEntity.getTaskNum())
                    .themeNum(moimEntity.getThemeNum())
                    .classPrice(moimEntity.getClassPrice())
                    .moimOrClass(moimEntity.getMoimOrClass())
                    .moimScheduleList(
                            moimScheduleEntityList.stream().map(moimScheduleEntityForFilter -> {
                                        return MoimSchedule.builder()
                                                .msNum(moimScheduleEntityForFilter.getMsNum())
                                                .msTime(moimScheduleEntityForFilter.getMsTime())
                                                .msArea(moimScheduleEntityForFilter.getMsArea())
                                                .moimNum(moimEntity.getMoimNum())
                                                .msHCount(moimScheduleEntityForFilter.getMsHCount())
                                                .memberId(moimScheduleEntityForFilter.getMemberId())
                                                .msTitle(moimScheduleEntityForFilter.getMsTitle())
                                                .msContent(moimScheduleEntityForFilter.getMsContent())
                                                .msDate(moimScheduleEntityForFilter.getMsDate())
                                                .memberList(
                                                        scheduleJoinEntityList.stream().filter(scheduleJoinEntityForFilter -> {
                                                            return scheduleJoinEntityForFilter.getMsNum().equals(moimScheduleEntityForFilter.getMsNum());
                                                        }).map(scheduleJoinEntityForFilter -> {
                                                            return memberEntityList.stream().filter(memberEntityForFilter -> {
                                                                return memberEntityForFilter.getMemberId().equals(scheduleJoinEntityForFilter.getMemberid());
                                                            }).map(memberEntityForFilter -> {
                                                                return Member.builder()
                                                                        .memberId(memberEntityForFilter.getMemberId())
                                                                        .memberImg(memberEntityForFilter.getMemberImg())
                                                                        .build();
                                                            }).findFirst().get();
                                                        }).collect(Collectors.toList())
                                                )
                                                .build();
                                    })
                                    .collect(Collectors.toList())
                    )
                    .build();

            Member member1 = Member.builder()
                            .memberId(memberEntity.getMemberId())
                            .memberImg(memberEntity.getMemberImg())
                            .build();

            List<Role> roleList = roleEntityList.stream().map(role -> {
                return Role.builder()
                        .memberId(role.getMemberId())
                        .role(role.getRole())
                        .moimNum(role.getMoimNum())
                        .build();
            }).collect(Collectors.toList());

            List<Role> moimMember = moimMemberEntityList.stream().map(role -> {
                return Role.builder()
                        .memberId(role.getMemberId())
                        .role(role.getRole())
                        .moimNum(role.getMoimNum())
                        .build();
            }).collect(Collectors.toList());

            List<ScheduleJoin> scheduleJoinList = scheduleJoinEntityList.stream().map(scheduleJoin -> {
                return ScheduleJoin.builder()
                        .msNum(scheduleJoin.getMsNum())
                        .moimNum(scheduleJoin.getMoimNum())
                        .sjNum(scheduleJoin.getSjNum())
                        .build();
            }).collect(Collectors.toList());

            return new ResMoimDetail(moimDetail1, member1, roleList, moimMember, scheduleJoinList);
        }
    }
}
