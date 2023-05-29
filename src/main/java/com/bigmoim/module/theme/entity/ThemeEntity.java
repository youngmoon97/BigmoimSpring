package com.bigmoim.module.theme.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThemeEntity {
  private Integer themeNum;
  private String themeName;

  @Override
  public String toString() {
    return "ThemeEntity[" +
            "themeNum=" + themeNum +
            ", themeName='" + themeName +
            "]";
  }
}