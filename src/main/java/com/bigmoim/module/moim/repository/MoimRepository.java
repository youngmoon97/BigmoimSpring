package com.bigmoim.module.moim.repository;

import com.bigmoim.module.moim.entity.MoimEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MoimRepository {
    List<MoimEntity> allMoim();
    MoimEntity findByMoimNum(int moinNum);
    List<MoimEntity> myMoimList(String memberId);
    List<MoimEntity> searchMoimList(String moimName);
    List<MoimEntity> classList();
    List<MoimEntity> businessList(int businessNum);
    List<MoimEntity> taskList(int taskNum);
    List<MoimEntity> themeList(int themeNum);
    List<MoimEntity> categoryList(int categoryNum);
    List<MoimEntity> areaList(String moimArea);
    Integer moimInsert(MoimEntity moimEntity);
    Integer moinUpdate(int moimNum);
    Integer moimDelete(int moimNum);
}
