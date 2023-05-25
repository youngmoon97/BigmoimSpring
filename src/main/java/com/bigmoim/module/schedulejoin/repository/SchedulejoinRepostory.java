package com.bigmoim.module.schedulejoin.repository;

import com.bigmoim.module.moimshcedule.entity.MoimScheduleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SchedulejoinRepostory {
    // <!--모든 모임일정 가져오기-->
    List<MoimScheduleEntity> allmoimScheduleList();

    // <!--모임스케줄에서 참여한 멤버 이름, 프로필, 사진 가져오기-->
    List<MoimScheduleEntity> moimScheduleImg(int moimNum);

    // 모임스케줄 리스트 받아오기
    List<MoimScheduleEntity> moimScheduleList(int moimNum);

    // <!--모임일정에서 일만 가져오기-->
    List<MoimScheduleEntity> moimScheduleDayList(int moimNum);

    // 모임일정에서 월 받아오기
    String moimScheduleMon(int moimNum);

    // 모임일정에서 요일만 가져오기
    String moimScheduleDayName(int moimNum);
    
    MoimScheduleEntity moimScheduleMember(int msNum);

    MoimScheduleEntity moimScheduleAllMember(int moimNum);

    // resultType이 없음
    List<MoimScheduleEntity> scheduleJoinMsvList(int msNum);

    MoimScheduleEntity moimManager(int moimNUm);

    Integer scjoinChk(@Param("moimNum") int moimNum , @Param("memberId") int memberId);

    Integer scJoin(@Param("msNum") int msNum, @Param("memberId") String memberId, @Param("moimNum") int moimNum);

    boolean moimMemberCheck(@Param("moimNum") int moimNum, @Param("memberId") String memberId);


}
