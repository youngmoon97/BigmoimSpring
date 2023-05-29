package com.bigmoim.module.member.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.common.exception.BadRequestException;
import com.bigmoim.module.business.repository.BusinessRepository;
import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.category.repository.CategoryRepository;
import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.member.repository.MemberRepository;
import com.bigmoim.module.member.repository.RoleRepository;
import com.bigmoim.module.task.dto.TaskDTO;
import com.bigmoim.module.task.repository.TaskRepository;
import com.bigmoim.module.theme.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceApiV1 {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public HttpEntity<?> signupProc(AuthDTO.ReqJoin reqDto) {

        // reqDto 안의 아이디가 이미 있는지 확인
        MemberEntity userEntityForCheck = memberRepository.getMember(reqDto.getMemberId());
        // 아이디가 있으면 익셉션 발생
        if (userEntityForCheck != null) {
            throw new BadRequestException("이미 사용 중인 아이디입니다.");
        }

        // 회원가입 (insert)
        memberRepository.insertMember(reqDto.toEntity(passwordEncoder));
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
    // TODO: 2023-05-29  비밀번호 찾기
//    @Transactional
//    public HttpEntity<?> findPwProc(AuthDTO.ReqJoin reqDto) {
//        String memberPw;
//        // reqDto 안의 아이디가 이미 있는지 확인
//        MemberEntity userEntityForCheck = memberRepository.getMember(reqDto.getMemberId());
//        // 아이디가 있으면 익셉션 발생
//        if (userEntityForCheck != null) {
//            memberPw = userEntityForCheck.getMemberId();
//        } else {
//            memberPw = "회원정보를 찾지 못했습니다.";
//        }
//
//        return new ResponseEntity<>(
//                ResDTO.builder()
//                        .code(0)
//                        .message("회원님의 아이디는 " + memberId + "입니다.")
//                        .build(),
//                HttpStatus.OK
//        );
//    }


//    public HttpEntity<?> getCategoryList(){
//        List<CategoryEntity> categoryEntityList = categoryRepository.categoryList();
//        return new ResponseEntity<>(
//                AuthDTO.ResSignup
//        )
//    }
}
