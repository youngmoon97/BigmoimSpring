package com.bigmoim.module.memberboard.dto;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.memberboard.entity.MemberBoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberboardDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqBasic{
        String mbTitle;
        String mbContent;
        String memberId;
        Integer moimNum;

        public MemberBoardEntity boardEntity(){
            return MemberBoardEntity.builder()
                    .mbTitle(mbTitle)
                    .mbContent(mbContent)
                    .mbDate(LocalDateTime.now())
                    .memberId(memberId)
                    .moimNum(moimNum)
                    .build();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class ResBasic{
        private List<Board> boardList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor

        static class Board{
            Integer mbNum;
            String mbTitle;
            String mbContent;
        }

        public static ResBasic fromEntityList(List<MemberBoardEntity> memberBoardEntityList){
            List<Board> boardList = memberBoardEntityList.stream().map(MemberBoardEntity -> {
                return Board.builder()
                        .mbNum(MemberBoardEntity.getMbNum())
                        .mbTitle(MemberBoardEntity.getMbTitle())
                        .mbContent(MemberBoardEntity.getMbContent())
                        .build();
            }).collect(Collectors.toList());

            return new ResBasic(boardList);
        }

    }
}
