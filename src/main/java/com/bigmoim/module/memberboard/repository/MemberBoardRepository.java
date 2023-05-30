package com.bigmoim.module.memberboard.repository;

import com.bigmoim.module.memberboard.entity.MemberBoardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberBoardRepository {

    MemberBoardEntity findByMemberId(Integer mbNum);
    List<MemberBoardEntity> boardList(Integer moinNum);
    Integer boardInsert(MemberBoardEntity memberBoardEntity);
    Integer boardDelete(Integer mbNum);
    Integer boardUpdate(MemberBoardEntity memberBoardEntity);

}
