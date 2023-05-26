package com.bigmoim.module.business.dto;

import com.bigmoim.module.business.entity.BusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class BusinessDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<Business> businnesList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        static class Business {
            int businessNum;
            String businessName;
        }

        public static ResBasic fromEntityList(List<BusinessEntity> businessEntityList) {
            List<ResBasic.Business> businessList = businessEntityList.stream().map(businessEntity -> {
                return Business.builder()
                        .businessNum(businessEntity.getBusinessNum())
                        .businessName(businessEntity.getBusinessName())
                        .build();
            }).collect(Collectors.toList());
            return new ResBasic(businessList);
        }
    }
}
