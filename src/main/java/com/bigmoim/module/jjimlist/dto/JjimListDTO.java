package com.bigmoim.module.jjimlist.dto;

import com.bigmoim.module.jjimlist.entity.JjimListEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class JjimListDTO {


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqBasic{
        private String memberId;
        private Integer moimNum;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<JjimList> jjimListList;

        //V1
        public JjimListEntity jjimListEntity(Integer jjimNum, String memberId, Integer moimNum) {
            return JjimListEntity.builder()
                    .jjimNum(jjimNum)
                    .memberId(memberId)
                    .moimNum(moimNum)
                    .build();
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class JjimList {
            Integer jjimNum;
            String memberId;
            Integer moimNum;
        }
        public static ResBasic fromEntityList(List<JjimListEntity> jjimListEntityList){
            List<JjimList> jjimListList =  jjimListEntityList.stream().map(jjimListEntity -> {
                return JjimList.builder()
                        .jjimNum(jjimListEntity.getJjimNum())
                        .memberId(jjimListEntity.getMemberId())
                        .moimNum(jjimListEntity.getMoimNum())
                        .build();
            }).collect(Collectors.toList());
            return new ResBasic(jjimListList);
        }
    }
}
