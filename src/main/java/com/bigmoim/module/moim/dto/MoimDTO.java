package com.bigmoim.module.moim.dto;

import com.bigmoim.module.moim.entity.MoimEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class MoimDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<Moim> moimList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        static class Moim {
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
        public static ResBasic fromEntityList(List<MoimEntity> moimEntityList){
            List<Moim> moimList =  moimEntityList.stream().map(moimEntity -> {
                return Moim.builder()
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
            return new ResBasic(moimList);
        }

//        public static ResBasic fromEntity(MoimEntity moimEntity){
//            MoimEntity moimEntity1 = moimEntity.stream().map(moimEntity ->{
//                return Moim.builder()
//                        .moimNum(moimEntity.getMoimNum())
//                        .moimName(moimEntity.getMoimName())
//                        .moimArea(moimEntity.getMoimArea())
//                        .moimHCount(moimEntity.getMoimHCount())
//                        .moimNCount(moimEntity.getMoimNCount())
//                        .memberId(moimEntity.getMemberId())
//                        .moimKakao(moimEntity.getMoimKakao())
//                        .categoryNum(moimEntity.getCategoryNum())
//                        .moimImg(moimEntity.getMoimImg())
//                        .moimProfile(moimEntity.getMoimProfile())
//                        .moimDate(moimEntity.getMoimDate())
//                        .businessNum(moimEntity.getBusinessNum())
//                        .taskNum(moimEntity.getTaskNum())
//                        .themeNum(moimEntity.getThemeNum())
//                        .classPrice(moimEntity.getClassPrice())
//                        .moimOrClass(moimEntity.getMoimOrClass())
//                        .build();
//            }).collect(Collectors.toEntity());
//            return new ResBasic(moimEntity1);
//            }
        }
    }
