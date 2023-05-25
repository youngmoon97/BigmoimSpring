package com.bigmoim.module.zipcode.repository;

import com.bigmoim.module.zipcode.entity.ZipcodeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ZipcodeRepository {

    // <!--우편번호 검색:area1(시), area2(구/동) 만 사용-->
    List<ZipcodeEntity> zipcodeRead(String area3);

    // 리스트 가져오기
    List<ZipcodeEntity> cityList();

    // <!--구 리스트 가져오기-->
    List<ZipcodeEntity> area2List(String area1);


}
