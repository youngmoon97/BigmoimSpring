package com.bigmoim.module.moim.dto;

import com.bigmoim.module.moim.entity.MoimEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class MoimDTO {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public static class ReqMakeMoim{

        //        @NotBlank(message = "모임명을 입력하세요.")
//        @Size(min = 2, message = "모임명은 2자 이상 입력해주세요.")
        private String moimName;

        //        @NotBlank(message = "모임 장소를 입력하세요.")
        private String moimArea;

        //        @NotNull(message = "최대 모임 인원을 입력하세요.")
        private Integer moimHCount;

        private String moimKakao;
        private Integer categoryNum;
        private String moimProfile;
        private Integer businessNum;
        private Integer taskNum;
        private Integer themeNum;
        private String classPrice;
        private Integer moimOrClass;

        public MoimEntity toEntity(String memberId, String moimImgUrl){
            return MoimEntity.builder()
                    .moimName(moimName)
                    .moimArea(moimArea)
                    .memberId(memberId)
                    .moimHCount(moimHCount)
                    .moimKakao(moimKakao)
                    .categoryNum(categoryNum)
                    .moimImg(moimImgUrl)
                    .moimProfile(moimProfile)
                    .businessNum(businessNum)
                    .taskNum(taskNum)
                    .themeNum(themeNum)
                    .classPrice(classPrice)
                    .moimOrClass(moimOrClass)
                    .build();
        }
    }
}
