package com.bigmoim.module.boardcomment.dto;

import com.bigmoim.module.boardcomment.entity.BoardCommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BoardCommentDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqBasic{
        Integer bcNum;
        String bcComment;
        LocalDateTime bcDate;
        Integer mbNum;
        String memberId;

        public BoardCommentEntity boardCommentEntity(){
            return BoardCommentEntity.builder()
                    .bcNum(bcNum)
                    .bcContent(bcComment)
                    .bcDate(LocalDateTime.now())
                    .mbNum(mbNum)
                    .memberId(memberId)
                    .build();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqUpdate{
        Integer bcNum;
        String bcComment;
        LocalDateTime bcDate;
        Integer mbNum;
        String memberId;

        public BoardCommentEntity boardComment(){
            return BoardCommentEntity.builder()
                    .bcNum(bcNum)
                    .bcContent(bcComment)
                    .bcDate(LocalDateTime.now())
                    .mbNum(mbNum)
                    .memberId(memberId)
                    .build();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic{
        private List<BoardComment> boardCommentList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        // 게시글 리스트 출력을 위한 DTO
        static class BoardComment{
            Integer bcNum;
            String bcComment;
            String memberId;
        }

        // 게시글을 리스트 형식으로 보여주기 위한 코드

        public static ResBasic fromEntityList(List<BoardCommentEntity> boardCommentEntityList){
            List<BoardComment> boardCommentList = boardCommentEntityList.stream().map(BoardCommentEntity ->{
                return BoardComment.builder()
                        .bcNum(BoardCommentEntity.getBcNum())
                        .bcComment(BoardCommentEntity.getBcContent())
                        .build();
            }).collect(Collectors.toList());

            return new ResBasic(boardCommentList);
        }
    }

}
