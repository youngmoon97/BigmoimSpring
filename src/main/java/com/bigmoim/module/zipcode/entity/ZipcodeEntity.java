package com.bigmoim.module.zipcode.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZipcodeEntity {
    private String zipcode;
    private String area1;
    private String area2;
    private String area3;
    private String area4;
}
