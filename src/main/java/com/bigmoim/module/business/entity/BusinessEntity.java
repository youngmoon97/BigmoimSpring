package com.bigmoim.module.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessEntity {
  private Integer businessNum;
  private String businessName;

  @Override
  public String toString() {
    return "BusinessEntity[" +
            "businessNum=" + businessNum +
            ", businessName='" + businessName + ']';
  }
}
