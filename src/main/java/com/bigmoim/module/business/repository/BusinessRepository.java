package com.bigmoim.module.business.repository;

import com.bigmoim.module.business.entity.BusinessEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BusinessRepository {
    List<BusinessEntity> businessList();
    String businessName(int businessNum);
}
