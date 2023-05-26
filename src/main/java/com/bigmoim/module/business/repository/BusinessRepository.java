package com.bigmoim.module.business.repository;

import com.bigmoim.module.business.entity.BusinessEntity;

import java.util.List;

public interface BusinessRepository {
    List<BusinessEntity> businessList();
    String businessName(int businessNum);
}
