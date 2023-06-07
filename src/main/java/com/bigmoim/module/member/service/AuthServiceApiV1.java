package com.bigmoim.module.member.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.common.exception.BadRequestException;
import com.bigmoim.module.amazon.controller.AmazonS3Controller;
import com.bigmoim.module.amazon.service.AwsS3Service;
import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.member.repository.MemberRepository;
import com.bigmoim.module.member.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceApiV1 {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AmazonS3Controller amazonS3Controller;
    private final AwsS3Service awsS3Service;


    @Transactional
    public HttpEntity<?> signupProc(AuthDTO.ReqJoin reqDto, List<MultipartFile> multipartFileList) {

        // reqDto 안의 아이디가 이미 있는지 확인
        MemberEntity userEntityForCheck = memberRepository.getMember(reqDto.getMemberId());
        // 아이디가 있으면 익셉션 발생
        if (userEntityForCheck != null) {
            throw new BadRequestException("이미 사용 중인 아이디입니다.");
        }
        List<String> urlList = awsS3Service.uploadFile(multipartFileList);
        System.out.println(urlList.get(0));
        // 회원가입 (insert)
        memberRepository.insertMember(reqDto.toEntity(passwordEncoder,urlList.get(0)));

        // 권한설정을 위해 insert한 데이터 select
        MemberEntity memberEntity = memberRepository.getMember(reqDto.getMemberId());


        // 권한 (insert)
        roleRepository.roleInsert(
                RoleEntity.builder()
                        .memberId(memberEntity.getMemberId())
                        .role("USER")
                        .createDate(LocalDateTime.now())
                        .build()
        );

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("회원가입에 성공했습니다.")
                        .build(),
                HttpStatus.OK
        );
    }

    // 아이디 찾기
    @Transactional
    public HttpEntity<?> findIdProc(AuthDTO.ReqJoin reqDto) {
        String memberId;
        // reqDto 안의 아이디가 이미 있는지 확인
        MemberEntity userEntityForCheck = memberRepository.getMember(reqDto.getMemberId());
        // 아이디가 있으면 익셉션 발생
        if (userEntityForCheck != null) {
            memberId = userEntityForCheck.getMemberId();
        } else {
            memberId = "아이디가 없습니다.";
        }

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("회원님의 아이디는 " + memberId + "입니다.")
                        .build(),
                HttpStatus.OK
        );
    }

}
