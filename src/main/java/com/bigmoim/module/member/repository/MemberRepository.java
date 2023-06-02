package com.bigmoim.module.member.repository;

import com.bigmoim.module.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberRepository {
    // TODO: 2023-05-24 시큐리티로 로그인
    MemberEntity loginMember(@Param("memberId") String memberId, @Param("memberPw") String memberPw);
    Integer checkId(String memberId);
    MemberEntity getMember(String memberId);
    List<MemberEntity> getMemberList();
    Integer updateMember(String memberId);
    Integer insertMember(MemberEntity memberEntity);
    Integer deleteMember(String memberId);
    String getIdSearch(@Param("memberName") String memberName, @Param("memberTel") String memberTel);
    Integer pwUpdate(MemberEntity memberEntity);
}
