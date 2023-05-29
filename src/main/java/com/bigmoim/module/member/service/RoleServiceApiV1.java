package com.bigmoim.module.member.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.jjimlist.dto.JjimListDTO;
import com.bigmoim.module.jjimlist.repository.JjimListRepository;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.member.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleServiceApiV1 {
    private final RoleRepository roleRepository;

    //멤버의 역할 찾아오기
    public HttpEntity<?> findById(String memberId){
        roleRepository.findById(memberId);

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("역할 찾기에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }
    
    //역할별 리스트
    public HttpEntity<?> findByRole(String role){
        roleRepository.findByRole(role);

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("역할별 리스트 찾기에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    //역할 제거
    @Transactional
    public HttpEntity<?> roleDelete(String memberId, String role){
        roleRepository.roleDelete(memberId, role);

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("역할 제거에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    //역할 추가
    @Transactional
    public HttpEntity<?> roleInsert(RoleEntity roleEntity){
        roleRepository.roleInsert(roleEntity);

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("역할 추가에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }
}
