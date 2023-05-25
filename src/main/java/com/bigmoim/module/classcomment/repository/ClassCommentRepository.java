package com.bigmoim.module.classcomment.repository;

import com.bigmoim.module.boardcomment.entity.BoardCommentEntity;
import com.bigmoim.module.classcomment.entity.ClassCommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClassCommentRepository {
    Integer ccInsert(ClassCommentEntity classCommentEntity);

    Integer ccUpdate(int ccNum);

    Integer ccDelete(int ccNum);

    ClassCommentEntity ccList(int moimNum);

    int getCcNum(@Param("memberId") String memberId,
                 @Param("moimNum") int moimNum,
                 @Param("ccComment") String ccComment);


}
