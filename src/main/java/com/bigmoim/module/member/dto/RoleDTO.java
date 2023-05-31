package com.bigmoim.module.member.dto;

import com.bigmoim.module.member.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RoleDTO {


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqBasic{
        private Integer roleIdx;
        private String memberId;
        private String role;
        private Integer moimNum;
        private LocalDateTime createDate;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<Role> RoleList;

        //V1
        public RoleEntity roleEntity(RoleEntity roleEntity) {
            return RoleEntity.builder()
                    .roleIdx(roleEntity.getRoleIdx())
                    .memberId(roleEntity.getMemberId())
                    .role(roleEntity.getRole())
                    .moimNum(roleEntity.getMoimNum())
                    .createDate(roleEntity.getCreateDate())
                    .build();
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Role {
            private Integer roleIdx;
            private String memberId;
            private String role;
            private Integer moimNum;
            private LocalDateTime createDate;
        }
        public static ResBasic fromEntityList(List<RoleEntity> RoleEntityList){
            List<Role> roleList =  RoleEntityList.stream().map(roleEntity -> {
                return Role.builder()
                        .roleIdx(roleEntity.getRoleIdx())
                        .memberId(roleEntity.getMemberId())
                        .role(roleEntity.getRole())
                        .moimNum(roleEntity.getMoimNum())
                        .createDate(roleEntity.getCreateDate())
                        .build();
            }).collect(Collectors.toList());
            return new ResBasic(roleList);
        }
    }
}
