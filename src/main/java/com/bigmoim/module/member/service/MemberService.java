package com.bigmoim.module.member.service;

import com.bigmoim.common.exception.BadRequestException;
import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
//    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public HttpEntity<?> joinProc(AuthDTO.ReqJoin reqDto){
//        MemberEntity memberEntityForCheck = memberRepository.findById(reqDto.getMemberId());
//        if(memberEntityForCheck!=null){
//            throw new BadRequestException("이미 사용 중인 아이디입니다.");
//        }
//        //memberRepository.insert(reqDto.toEntity(passwordEncoder));
//        MemberEntity memberEntity = memberRepository.findById(reqDto.getMemberId());
//        // TODO: 2023-05-22
//        memberRepository.insert(
//                MemberEntity.builder()
//                        .memberId(memberEntity.getMemberId())
//                        .memberPw(memberEntity.getMemberPw())
//                        .memberImg(memberEntity.getMemberImg())
//                        .build()
//        );
//        return null;
//    }
}
