package com.bigmoim.module.recentseen.repository;

import com.bigmoim.module.jjimlist.entity.JjimListEntity;
import com.bigmoim.module.moim.entity.MoimEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecentSeenRepository {

    List<MoimEntity> rsList(String memberId);

    Integer rsInsert(@Param("memberId") String memberId,
                     @Param("moimNum") Integer moimNum);

    Integer rsUpdate(@Param("memberId") String memberId,
                     @Param("moimNum") Integer moimNum);
}
