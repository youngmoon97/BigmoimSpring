package com.bigmoim.module.moimshcedule.repository;

import com.bigmoim.module.moimshcedule.entity.MoimScheduleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MoimScheduleRepository {
    List<MoimScheduleEntity> allmoimSchedule();
    Integer mjAccept(@Param("memberId") String memberId, @Param("moimNum") int moimNum);
    Integer mjDelete(@Param("memberId") String memberId, @Param("moimNum") int moimNum);
    Integer msInsert(MoimScheduleEntity moimScheduleEntity);
}
