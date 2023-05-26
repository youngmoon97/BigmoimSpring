package com.bigmoim.module.member.dto;

import com.bigmoim.module.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuthDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqJoin{
        @NotBlank(message = "아이디를 입력하세요.")
        @Size(min = 5, message = "아이디는 5자 이상 입력해주세요.")
        private String memberId;

        @NotBlank(message = "비밀번호를 입력하세요.")
        @Size(min = 5, message = "비밀번호는 5자 이상으로 입력해주세요.")
        private String pw;


        // TODO: 2023-05-22
//        public MemberEntity toEntity(PasswordEncoder passwordEncoder){
//            return MemberEntity.builder()
//                    .memberId(memberId)
//                    .memberPw(passwordEncoder.encode(memberPw))
//
//                    .build();
//        }
    }



}

