package com.bigmoim.module.member.repository;

import com.bigmoim.module.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminRepository {

    MemberEntity adminCheck(@Param("adminId") String adminId,
                            @Param("adminPw") String adminPw);
}

