package com.bigmoim.module.boardcomment.repository;

import com.bigmoim.module.boardcomment.entity.BoardCommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardCommentRepository {
    List<BoardCommentEntity> bcList(int mbNum);

    Integer bcInsert(BoardCommentEntity boardCommentEntity);

    Integer bcDelete(int bcNum);

    Integer bcUpdate(BoardCommentEntity boardCommentEntity);

    BoardCommentEntity findBcMemberId(Integer bcNum);
}
