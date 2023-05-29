package com.bigmoim.module.theme.dto;

import com.bigmoim.module.theme.entity.ThemeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.context.Theme;

import java.util.List;
import java.util.stream.Collectors;

public class ThemeDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic{
        private List<Theme> themeList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Theme{
            Integer themeNum;
            String themeName;
        }

        public static ResBasic fromEntityList(List<ThemeEntity> themeEntityList){
            List<Theme> themeList = themeEntityList.stream().map(themeEntity -> {
                return Theme.builder()
                        .themeNum(themeEntity.getThemeNum())
                        .themeName(themeEntity.getThemeName())
                        .build();
            }).collect(Collectors.toList());
            return new ResBasic(themeList);
        }
    }
}
