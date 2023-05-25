package com.bigmoim.module.moimphotos.repository;

import com.bigmoim.module.moimphotos.entity.MoimPhotosEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MoimPhotosRepository {
    List<MoimPhotosEntity> photoList(int moimNum);
    MoimPhotosEntity photoDetail(int photoNum);
    Integer photoUpdate(int photoNum);
    Integer photoDelete(@Param("photoNum") int photoNum, @Param("memberId") String memberId);
    Integer photoAdd(MoimPhotosEntity moimPhotosEntity);
}
