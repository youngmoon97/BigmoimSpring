package com.bigmoim.module.moim.service;

import com.bigmoim.common.dto.ResDTO;
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
    private MoimRepository moimRepository;
    private RoleRepository roleRepository;

    @Transactional
    public HttpEntity<?> moimInsert(MoimDTO.ReqMakeMoim reqMakeMoim) {

        moimRepository.moimInsert(reqMakeMoim.toEntity());

        roleRepository.roleInsert(
                RoleEntity.builder()
                        .memberId(reqMakeMoim.toEntity().getMemberId())
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
