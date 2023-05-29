package com.bigmoim.module.recentseen.dto;

import com.bigmoim.module.recentseen.entity.RecentSeenEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RecentSeenDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqBasic {
        private Integer resentseenNum;
        private String memberId;
        private Integer moimNum;
        private LocalDateTime rsDate;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<RecentSeen> recentSeenList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class RecentSeen {
            private Integer resentseenNum;
            private String memberId;
            private Integer moimNum;
            private LocalDateTime rsDate;
        }

        public static ResBasic fromEntityList(List<RecentSeenEntity> RecentSeenEntityList) {
            List<RecentSeen> recentSeenList = RecentSeenEntityList.stream().map(RecentSeenEntity -> {
                return RecentSeen.builder()
                        .resentseenNum(RecentSeenEntity.getResentseenNum())
                        .memberId(RecentSeenEntity.getMemberId())
                        .moimNum(RecentSeenEntity.getMoimNum())
                        .rsDate(RecentSeenEntity.getRsDate())
                        .build();
            }).collect(Collectors.toList());
            return new ResBasic(recentSeenList);
        }
    }
}
