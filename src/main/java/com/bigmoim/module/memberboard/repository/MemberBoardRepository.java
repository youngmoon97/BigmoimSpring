package com.bigmoim.module.memberboard.repository;

import com.bigmoim.module.memberboard.entity.MemberBoardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberBoardRepository {
    List<MemberBoardEntity> boardList(int moinNum);
    Integer boardInsert(MemberBoardEntity memberBoardEntity);
    Integer boardDelete(@Param("mbNum") int mbNum, @Param("memberId") String memberId);
    Integer boardUpdate(int mbNum);

}
