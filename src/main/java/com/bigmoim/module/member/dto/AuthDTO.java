package com.bigmoim.module.member.dto;

import com.bigmoim.module.business.dto.BusinessDTO;
import com.bigmoim.module.business.entity.BusinessEntity;
import com.bigmoim.module.category.dto.CategoryDTO;
import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.task.dto.TaskDTO;
import com.bigmoim.module.task.entity.TaskEntity;
import com.bigmoim.module.theme.dto.ThemeDTO;
import com.bigmoim.module.theme.entity.ThemeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AuthDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqJoin{
        @NotBlank(message = "아이디를 입력하세요.")
        @Size(min = 5, message = "아이디는 5자 이상 입력해주세요.")
        private String memberId;

        @NotBlank(message = "비밀번호를 입력하세요.")
        @Size(min = 5, message = "비밀번호는 5자 이상으로 입력해주세요.")
        private String memberPw;
        
        @NotBlank(message = "이름를 입력하세요.")
        @Size(min = 5, message = "비밀번호는 5자 이상으로 입력해주세요.")
        private String memberName;

        @NotBlank(message = "전화번호를 입력하세요.")
        @Size(min = 5, message = "비밀번호는 5자 이상으로 입력해주세요.")
        private String memberTel;

        @NotBlank(message = "생년월일를 입력하세요.")
        @Size(min = 5, message = "비밀번호는 5자 이상으로 입력해주세요.")
        private String memberBirth;

        private String memberImg;

        @Size(max = 100, message = "자기소개는 100자 이내로 작성해주세요.")
        private String memberProfile;

        @NotBlank(message = "성별를 입력하세요.")
        @Size(min = 5, message = "비밀번호는 5자 이상으로 입력해주세요.")
        private Integer memberGender;

        @NotBlank(message = "주소를 입력하세요.")
        @Size(min = 5, message = "비밀번호는 5자 이상으로 입력해주세요.")
        private String memberAddr;

        private String memberJobAddr;
        private String memberLikeArea;
        private Integer categoryNum;
        private Integer businessNum;
        private Integer taskNum;
        private Integer themeNum;

        public MemberEntity toEntity(PasswordEncoder passwordEncoder){
            return MemberEntity.builder()
                    .memberId(memberId)
                    .memberPw(passwordEncoder.encode(memberPw))
                    .memberName(memberName)
                    .memberTel(memberTel)
                    .memberBirth(memberBirth)
                    .memberImg(memberImg)
                    .memberProfile(memberProfile)
                    .memberGender(memberGender)
                    .memberAddr(memberAddr)
                    .memberJobAddr(memberJobAddr)
                    .memberLikeArea(memberLikeArea)
                    .categoryNum(categoryNum)
                    .taskNum(taskNum)
                    .themeNum(themeNum)
                    .build();
        }
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqFindId{

        @NotBlank(message = "아이디를 입력하세요.")
        @Size(min = 5, message = "아이디는 5자 이상 입력해주세요.")
        private String memberName;

        @NotBlank(message = "전화번호을 입력하세요.")
        @Size(min = 11, message = "전화번호 11자 입력해주세요.")
        private String memberTel;

        public MemberEntity toEntity(){
            return MemberEntity.builder()
                    .memberName(memberName)
                    .memberTel(memberTel)
                    .build();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqFindPw{

        @NotBlank(message = "아이디를 입력하세요.")
        @Size(min = 5, message = "아이디는 5자 이상 입력해주세요.")
        private String memberId;

        @NotBlank(message = "이름을 입력하세요.")
        private String memberName;

        @NotBlank(message = "전화번호을 입력하세요.")
        @Size(min = 11, message = "전화번호 11자 입력해주세요.")
        private String memberTel;

        public MemberEntity toEntity(){
            return MemberEntity.builder()
                    .memberId(memberId)
                    .memberName(memberName)
                    .memberTel(memberTel)
                    .build();
        }
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResSignup {

        private List<CategoryDTO.ResBasic.Category> categoryList;
        private List<BusinessDTO.ResBasic.Business> businessList;
        private List<TaskDTO.ResBasic.Task> taskList;
        private List<ThemeDTO.ResBasic.Theme> themeList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Category {
            int categoryNum;
            String categoryName;
            String categoryImg;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Business {
            Integer businessNum;
            String businessName;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Task {
            Integer taskNum;
            String taskName;
        }
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Theme{
            Integer themeNum;
            String themeName;
        }
        public static AuthDTO.ResSignup fromAllEntityList(
                List<CategoryEntity> categoryEntityList,
                List<BusinessEntity> businessEntityList,
                List<TaskEntity> taskEntityList,
                List<ThemeEntity> themeEntityList) {
            // TODO: 2023-05-29 나머지리턴값만들기
            List<CategoryDTO.ResBasic.Category> categoryList =  categoryEntityList.stream().map(categoryEntity -> {
//                return Category(1, "자기계발","ㅁㄴㅇ");
                return CategoryDTO.ResBasic.Category.builder()
                        .categoryNum(categoryEntity.getCategoryNum())
                        .categoryName(categoryEntity.getCategoryName())
                        .categoryImg(categoryEntity.getCategoryImg())
                        .build();
            }).collect(Collectors.toList());
            List<BusinessDTO.ResBasic.Business> businessList =  businessEntityList.stream().map(businessEntity -> {
//                return Category(1, "자기계발","ㅁㄴㅇ");
                return BusinessDTO.ResBasic.Business.builder()
                        .businessNum(businessEntity.getBusinessNum())
                        .businessName(businessEntity.getBusinessName())
                        .build();
            }).collect(Collectors.toList());
            List<TaskDTO.ResBasic.Task> taskList =  taskEntityList.stream().map(taskEntity -> {
//                return Category(1, "자기계발","ㅁㄴㅇ");
                return TaskDTO.ResBasic.Task.builder()
                        .taskNum(taskEntity.getTaskNum())
                        .taskName(taskEntity.getTaskName())
                        .build();
            }).collect(Collectors.toList());
            List<ThemeDTO.ResBasic.Theme> themeList =  themeEntityList.stream().map(themeEntity -> {
//                return Category(1, "자기계발","ㅁㄴㅇ");
                return ThemeDTO.ResBasic.Theme.builder()
                        .themeNum(themeEntity.getThemeNum())
                        .themeName(themeEntity.getThemeName())
                        .build();
            }).collect(Collectors.toList());

            return new ResSignup(categoryList, businessList, taskList, themeList);
        }
    }


}

