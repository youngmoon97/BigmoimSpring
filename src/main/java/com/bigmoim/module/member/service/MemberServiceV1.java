package com.bigmoim.module.member.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.common.exception.BadRequestException;
import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceV1 {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public HttpEntity<?> getIdSearch(AuthDTO.ReqFindId reqFindId){
        String memberName = reqFindId.getMemberName();
        String memberTel = reqFindId.getMemberTel();
        String memberId = memberRepository.getIdSearch(memberName, memberTel);
        if(memberId==null)
            throw new BadRequestException("아이디가 존재하지 않습니다.");
        //        return memberId;

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("아이디를 찾았습니다.")
                        .data(memberId)
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public HttpEntity<?> upDatePw(AuthDTO.ReqUpdatePw reqUpdatePw){
        MemberEntity memberEntity = memberRepository.getMember(reqUpdatePw.getMemberId());


        if(!memberEntity.getMemberId().equals(reqUpdatePw.getMemberId())
                && !memberEntity.getMemberTel().equals(reqUpdatePw.getMemberTel())){
            throw new BadRequestException("아이디와 비밀번호를 확인해주세요");
        }

        String changePw = bCryptPasswordEncoder.encode(reqUpdatePw.getMemberPw());

        System.out.println(changePw);

        memberEntity.setMemberPw(changePw);

        memberRepository.pwUpdate(memberEntity);


        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("비밀번호 변경 성공")
                        .build(),
                HttpStatus.OK);
    }
}
