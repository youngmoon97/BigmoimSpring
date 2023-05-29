package com.bigmoim.module.jjimlist.repository;

import com.bigmoim.module.jjimlist.entity.JjimListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JjimListRepository {

    Integer jjimInsert(@Param("memberId") String memberId,
                       @Param("moimNum") Integer moimNum);

    Integer jjimCheck(@Param("memberId") String memberId,
                      @Param("moimNum")Integer moimNum);

    Integer jjimDelete (@Param("memberId") String memberId,
                        @Param("moimNum") Integer moimNum);

    Integer jjimCount (Integer moimNum);

     List<JjimListEntity> jjimList(String memberId);
}
