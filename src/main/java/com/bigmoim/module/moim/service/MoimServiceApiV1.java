package com.bigmoim.module.moim.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.member.repository.RoleRepository;
import com.bigmoim.module.moim.dto.MoimDTO;
import com.bigmoim.module.moim.repository.MoimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MoimServiceApiV1 {
    private final MoimRepository moimRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public HttpEntity<?> moimInsert(CustomUserDetails customUserDetails, MoimDTO.ReqMakeMoim reqMakeMoim) {

        if(moimRepository==null)
            System.out.println("null...........");
        else
            System.out.println(moimRepository);

        moimRepository.moimInsert(reqMakeMoim.toEntity(customUserDetails.getUsername()));

        roleRepository.roleInsert(
                RoleEntity.builder()
                        .memberId(customUserDetails.getUsername())
                        .role("Leader")
                        .createDate(LocalDateTime.now())
                        .build()
        );

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모임을 생성했습니다.")
                        .build(),
                HttpStatus.OK);
    }
}
