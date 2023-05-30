package com.bigmoim.module.classcomment.dto;

import com.bigmoim.module.classcomment.entity.ClassCommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ClassCommentDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class ReqBasic{
        Integer ccNum;
        String ccComment;
        String memberId;
        Integer moimNum;
        LocalDateTime ccDate;

        public ClassCommentEntity classCommentEntity(){
            return ClassCommentEntity.builder()
                    .ccComment(ccComment)
                    .memberId(memberId)
                    .moimNum(moimNum)
                    .ccDate(LocalDateTime.now())
                    .build();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class ReqUpdate{
        Integer ccNum;
        String ccComment;
        String memberId;
        Integer moimNum;
        LocalDateTime ccDate;

        public ClassCommentEntity classCommentEntity(){
            return ClassCommentEntity.builder()
                    .ccComment(ccComment)
                    .memberId(memberId)
                    .moimNum(moimNum)
                    .ccDate(LocalDateTime.now())
                    .build();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic{
        private List<ClassComment> classCommentList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor

        static class ClassComment{
            Integer ccNum;
            String ccComment;
            String memberId;

        }

        public static ResBasic fromEntityList(List<ClassCommentEntity> classCommentEntityList){
            List<ClassComment> classCommentList = classCommentEntityList.stream().map(ClassCommentEntity->{
                return ClassComment.builder()
                        .ccNum(ClassCommentEntity.getCcNum())
                        .ccComment(ClassCommentEntity.getCcComment())
                        .memberId(ClassCommentEntity.getMemberId())
                        .build();
            }).collect(Collectors.toList());

            return new ResBasic(classCommentList);
        }
    }
}
