package com.bigmoim.module.member.repository;

import com.bigmoim.module.admin.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminRepository {

    AdminEntity adminCheck(@Param("adminId") String adminId,
                           @Param("adminPw") String adminPw);
}
