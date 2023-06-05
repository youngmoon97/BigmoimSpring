package com.bigmoim.module.schedulejoin.repository;

import com.bigmoim.module.moimshcedule.entity.MoimScheduleEntity;
import com.bigmoim.module.schedulejoin.entity.ScheduleJoinEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SchedulejoinRepostory {
    List<ScheduleJoinEntity> scheduleJoinList(Integer moimNum, Integer msNum);
    List<ScheduleJoinEntity> allScheduleJoinList();
    List<ScheduleJoinEntity> moimschedulejoin(Integer moimNum);
    Integer sjInsert(ScheduleJoinEntity scheduleJoinEntity);

}
