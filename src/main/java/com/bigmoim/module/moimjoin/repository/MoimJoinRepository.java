package com.bigmoim.module.moimjoin.repository;


import com.bigmoim.module.moimjoin.entity.MoimJoinEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MoimJoinRepository {
    List<MoimJoinEntity> findBymoimNum(int moimNum);
    Integer mjAccept(@Param("memberId") String memberId, @Param("moimNum") int moimNum);
    Integer mjDelete(@Param("memberId") String memberId, @Param("moimNum") int moimNum);
    Integer mjInsert(MoimJoinEntity moimJoinEntity);
}
