package com.bigmoim.module.business.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.business.dto.BusinessDTO;
import com.bigmoim.module.business.entity.BusinessEntity;
import com.bigmoim.module.business.repository.BusinessRepository;
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
public class BusinessService {
    private final BusinessRepository businessRepository;

    public BusinessDTO.ResBasic getBusinessList() {
        return BusinessDTO.ResBasic.fromEntityList(businessRepository.businessList());
    }

//    public HttpEntity<?> businessList(){
//        List<BusinessEntity> businessEntityList = businessRepository.businessList();
//        return new ResponseEntity<>(
//                ResDTO.builder()
//                        .code(0)
//                        .message("업종 리스트 조희에 성공하였습니다.")
//                        .data(BusinessDTO.ResBasic.fromEntityList(businessEntityList).getBusinnesList())
//                        .build(),
//                HttpStatus.OK);
//    }
}
