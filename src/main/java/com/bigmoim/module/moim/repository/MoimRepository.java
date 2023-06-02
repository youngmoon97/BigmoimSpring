package com.bigmoim.module.moim.repository;

import com.bigmoim.module.moim.entity.MoimEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MoimRepository {
    List<MoimEntity> allMoim();
    MoimEntity findByMoimNum(Integer moinNum);
    List<MoimEntity> myMoimList(String memberId);
    List<MoimEntity> searchMoimList(String moimName);
    List<MoimEntity> classList(String moimArea);
    List<MoimEntity> allclassList();
    List<MoimEntity> businessList(Integer businessNum);
    List<MoimEntity> taskList(Integer taskNum);
    List<MoimEntity> themeList(Integer themeNum);
    List<MoimEntity> categoryList(Integer categoryNum);
    List<MoimEntity> areaList(String moimArea);
    List<MoimEntity> joinMoimList(String memberId);
    List<MoimEntity> newMoimList();
    Integer moimInsert(MoimEntity moimEntity);
    Integer moinUpdate(Integer moimNum);
    Integer moimDelete(Integer moimNum);
}
