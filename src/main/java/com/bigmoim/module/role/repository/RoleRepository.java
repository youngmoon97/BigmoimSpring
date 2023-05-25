package com.bigmoim.module.role.repository;

import com.bigmoim.module.role.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleRepository {
    List<RoleEntity> FindById(String memberId);

    List<RoleEntity> findByRole(String role);

    Integer roleDelete(String memberId);

    Integer roleInsert(RoleEntity roleEntity);


}
