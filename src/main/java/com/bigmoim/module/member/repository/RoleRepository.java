package com.bigmoim.module.member.repository;

import com.bigmoim.module.member.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleRepository {
    List<RoleEntity> findById(String memberId);

    List<RoleEntity> findByRole(String role);

    Integer roleDelete(@Param("memberId") String memberId, @Param("role") String role);

    Integer roleInsert(RoleEntity roleEntity);
}
