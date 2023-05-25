package com.bigmoim.module.boardcomment.repository;

import com.bigmoim.module.boardcomment.entity.BoardCommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardCommentRepository {
    BoardCommentEntity bcList(int mbNum);

    Integer bcInsert(BoardCommentEntity boardCommentEntity);

    Integer bcDelete(int bcNum);

    Integer bcUpdate(int bcNum);
}
