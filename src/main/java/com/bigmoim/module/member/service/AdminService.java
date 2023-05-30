package com.bigmoim.module.member.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.member.dto.AdminDTO;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.repository.MemberRepository;
import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.moim.repository.MoimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {
    private final MemberRepository memberRepository;
    private final MoimRepository moimRepository;

    public AdminDTO.ResMember getMemberList() {
        List<MemberEntity> memberList = memberRepository.getMemberList();
        return AdminDTO.ResMember.fromMemberEntity(memberList);
    }

    public AdminDTO.ResMoim getMoimList() {
        List<MoimEntity> moimList = moimRepository.allMoim();
        return AdminDTO.ResMoim.fromMoimEntity(moimList);
    }

    public HttpEntity<?> moimDelete(Integer moimNum){
        Integer moimDeleteResult = moimRepository.moimDelete(moimNum);
        if(moimDeleteResult == 0){
            return new ResponseEntity<>(
                    ResDTO.builder()
                            .code(1)
                            .message("모임삭제 에러가 발생했습니다.")
                            .build(),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                    ResDTO.builder()
                            .code(0)
                            .message("모임이 삭제되었습니다.")
                            .build(),
                    HttpStatus.OK);
        }
    }

    public HttpEntity<?> deleteMember(String memberId){
        Integer memberDeleteResult = memberRepository.deleteMember(memberId);
        if(memberDeleteResult == 0){
            return new ResponseEntity<>(
                    ResDTO.builder()
                            .code(1)
                            .message("회원추방 에러가 발생했습니다.")
                            .build(),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                    ResDTO.builder()
                            .code(0)
                            .message("회원이 추방되었습니다.")
                            .build(),
                    HttpStatus.OK);
        }
    }
}