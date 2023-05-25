package com.bigmoim.module.jjimlist.repository;

import com.bigmoim.module.jjimlist.entity.JjimListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JjimListRepository {

    Integer jjimInsert(JjimListEntity jjimListEntity);

    Integer jjimCheck(@Param("memberId") String memberId,
                      @Param("moimNum")int moimNum);

    Integer jjimDelete (@Param("memberId") String memberId,
                        @Param("moimNum") int moimNum);

    int jjimCount (int moimNum);

     List<JjimListEntity> jjimList(String memberId);
}
