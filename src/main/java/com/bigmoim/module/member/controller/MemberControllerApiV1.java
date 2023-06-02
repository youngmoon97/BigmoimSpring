package com.bigmoim.module.member.controller;

import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.service.MemberService;
import com.bigmoim.module.member.service.MemberServiceV1;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberControllerApiV1 {

    private final MemberServiceV1 memberServiceV1;


    @GetMapping("/memberIdString")
    @ResponseBody
    public HttpEntity<?> memberIdString(@Param("memberName") String memberName, @Param("memberTel") String memberTel, AuthDTO.ReqFindId reqFindId){
        reqFindId.setMemberName(memberName);
        reqFindId.setMemberTel(memberTel);
//        model.addAttribute(memberServiceV1.getIdSearch(reqFindId));
//        model.addAttribute("memberName", memberName);
//        model.addAttribute("memberTel", memberTel);
        System.out.println(memberServiceV1.getIdSearch(reqFindId));
        return memberServiceV1.getIdSearch(reqFindId);
    }

    @PutMapping("/memberPwString")
    @ResponseBody
    public HttpEntity memberPwString(AuthDTO.ReqUpdatePw reqUpdatePw
    , @Param("memberId") String memberId, @Param("memberTel") String memberTel
    , @Param("memberPw") String memberPw){

        reqUpdatePw.setMemberId(memberId);
        reqUpdatePw.setMemberTel(memberTel);
        reqUpdatePw.setMemberPw(memberPw);
        System.out.println(memberServiceV1.upDatePw(reqUpdatePw));
        return memberServiceV1.upDatePw(reqUpdatePw);
    }
}
