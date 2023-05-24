package com.bigmoim.module.member.repository;

import com.bigmoim.module.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberRepository {
    MemberEntity findById(String memberId);
    Integer insert(MemberEntity memberEntity);


}
