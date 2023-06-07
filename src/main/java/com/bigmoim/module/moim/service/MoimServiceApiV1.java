package com.bigmoim.module.moim.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.amazon.service.AwsS3Service;
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
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MoimServiceApiV1 {
    private final MoimRepository moimRepository;
    private final RoleRepository roleRepository;
    private final AwsS3Service awsS3Service;

    @Transactional
    public HttpEntity<?> moimInsert(CustomUserDetails customUserDetails, MoimDTO.ReqMakeMoim reqMakeMoim
            , List<MultipartFile> multipartFileList) {

        if(moimRepository==null)
            System.out.println("null...........");
        else
            System.out.println(moimRepository);

        List<String> urlList = awsS3Service.uploadFile(multipartFileList);
        System.out.println(urlList.get(0));
        moimRepository.moimInsert(reqMakeMoim.toEntity(customUserDetails.getUsername(), urlList.get(0)));

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
