package com.bigmoim.module.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEntity {
    private int notiNum;
    private String memberId;
    private int photoNum;
    private int mbNum;
    private int msNum;
    private int read;
    private int ccNum;
}
