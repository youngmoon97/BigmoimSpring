package com.bigmoim.module.moim.dto;

import com.bigmoim.module.business.entity.BusinessEntity;
import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.task.entity.TaskEntity;
import com.bigmoim.module.theme.entity.ThemeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.taglibs.standard.extra.spath.Step;

import java.util.List;
import java.util.stream.Collectors;

public class MainDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<Class> classList;
        private List<AllClass> allclassList;
        private List<AllMoim> allMoimList;
        private Member member;
        private List<Role> roleList;
        private List<Category> categoryList;
        private List<Business> businessList;
        private List<Task> taskList;
        private List<Theme> themeList;
        private List<NewMoim> newMoimList;
        private List<RecoMoim> recoMoimList;
        private List<JoinMoim> joinMoimList;
        private List<BusinessMoim> businessMoimList;
        private List<TaskMoim> taskMoimList;
        private List<ThemeMoim> themeMoimList;


        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Category {
            private Integer categoryNum;
            private String categoryName;
            private String categoryImg;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Business {
            private Integer businessNum;
            private String businessName;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Task {
            private Integer taskNum;
            private String taskName;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Theme {
            private Integer themeNum;
            private String themeName;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Member {
            private String memberId;
            private String memberImg;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Role {
            private String memberId;
            private String role;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Class {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AllClass {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AllMoim {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class NewMoim {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class RecoMoim {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class JoinMoim {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class BusinessMoim {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class TaskMoim {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ThemeMoim {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        public static ResBasic fromEntityList(
                List<MoimEntity> moimEntityList,
                List<MoimEntity> allMoimEntityList,
                MemberEntity memberEntity,
                List<RoleEntity> roleEntityList,
                List<CategoryEntity> categoryEntityList,
                List<MoimEntity> newMoimEntityList,
                List<MoimEntity> allclassEntityList,
                List<MoimEntity> recoMoimEntityList,
                List<MoimEntity> joinMoimEntityList,
                List<MoimEntity> businessMoimEntityList,
                List<MoimEntity> taskMoimEntityList,
                List<MoimEntity> themeMoimEntityList,
                List<BusinessEntity> businessEntityList,
                List<TaskEntity> taskEntityList,
                List<ThemeEntity> themeEntityList
        ) {

            List<Class> classList = moimEntityList.stream().map(moimEntity -> {
                return Class.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());
            List<AllClass> allclassList = allclassEntityList.stream().map(moimEntity -> {
                return AllClass.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());
            List<AllMoim> allMoimList = allMoimEntityList.stream().map(moimEntity -> {
                return AllMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());

            Member member = Member.builder()
                    .memberId(memberEntity.getMemberId())
                    .memberImg(memberEntity.getMemberImg())
                    .build();

            List<Role> roleList = roleEntityList.stream().map(role -> {
                return Role.builder()
                        .memberId(role.getMemberId())
                        .role(role.getRole())
                        .build();
            }).collect(Collectors.toList());

            List<Category> categoryList = categoryEntityList.stream().map(category -> {
                return Category.builder()
                        .categoryNum(category.getCategoryNum())
                        .categoryName(category.getCategoryName())
                        .categoryImg(category.getCategoryImg())
                        .build();
            }).collect(Collectors.toList());
            List<Business> businessList = businessEntityList.stream().map(business -> {
                return Business.builder()
                        .businessNum(business.getBusinessNum())
                        .businessName(business.getBusinessName())
                        .build();
            }).collect(Collectors.toList());
            List<Task> taskList = taskEntityList.stream().map(task -> {
                return Task.builder()
                        .taskNum(task.getTaskNum())
                        .taskName(task.getTaskName())
                        .build();
            }).collect(Collectors.toList());
            List<Theme> themeList = themeEntityList.stream().map(theme -> {
                return Theme.builder()
                        .themeNum(theme.getThemeNum())
                        .themeName(theme.getThemeName())
                        .build();
            }).collect(Collectors.toList());
            List<NewMoim> newMoimList = newMoimEntityList.stream().map(moimEntity -> {
                return NewMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());

            List<RecoMoim> recoMoimList = recoMoimEntityList.stream().map(moimEntity -> {
                return RecoMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());
            List<JoinMoim> joinMoimList = joinMoimEntityList.stream().map(moimEntity -> {
                return JoinMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());
            List<BusinessMoim> businessMoimList = businessMoimEntityList.stream().map(moimEntity -> {
                return BusinessMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());
            List<TaskMoim> taskMoimList = taskMoimEntityList.stream().map(moimEntity -> {
                return TaskMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());
            List<ThemeMoim> themeMoimList = themeMoimEntityList.stream().map(moimEntity -> {
                return ThemeMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());

            return new ResBasic(classList, allclassList, allMoimList, member, roleList, categoryList, businessList,
                    taskList, themeList, newMoimList, recoMoimList, joinMoimList, businessMoimList, taskMoimList, themeMoimList);
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResCategoryMoim {
        private Member member;
        private List<Role> roleList;
        private String categoryName;
        private List<Category> categoryList;
        private List<CategoryMoim> categoryMoimList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Category {
            private Integer categoryNum;
            private String categoryName;
            private String categoryImg;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Member {
            private String memberId;
            private String memberImg;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Role {
            private String memberId;
            private String role;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class CategoryMoim {
            Integer moimNum;
            String moimName;
            String moimArea;
            Integer moimHCount;
            Integer moimNCount;
            String memberId;
            String moimKakao;
            Integer categoryNum;
            String moimImg;
            String moimProfile;
            String moimDate;
            Integer businessNum;
            Integer taskNum;
            Integer themeNum;
            String classPrice;
            Integer moimOrClass;
        }

        public static ResCategoryMoim fromEntityList(MemberEntity memberEntity, List<RoleEntity> roleEntityList,
                                                     List<CategoryEntity> categoryEntityList, List<MoimEntity> categoryMoimEntityList,
                                                     Integer categoryNum) {
            Member member = Member.builder()
                    .memberId(memberEntity.getMemberId())
                    .memberImg(memberEntity.getMemberImg())
                    .build();

            List<Role> roleList = roleEntityList.stream().map(role -> {
                return Role.builder()
                        .memberId(role.getMemberId())
                        .role(role.getRole())
                        .build();
            }).collect(Collectors.toList());

            List<Category> categoryList = categoryEntityList.stream().map(category -> {
                return Category.builder()
                        .categoryNum(category.getCategoryNum())
                        .categoryName(category.getCategoryName())
                        .categoryImg(category.getCategoryImg())
                        .build();
            }).collect(Collectors.toList());
            List<CategoryMoim> categoryMoimList = categoryMoimEntityList.stream().map(moimEntity -> {
                return CategoryMoim.builder()
                        .moimNum(moimEntity.getMoimNum())
                        .moimName(moimEntity.getMoimName())
                        .moimArea(moimEntity.getMoimArea())
                        .moimHCount(moimEntity.getMoimHCount())
                        .moimNCount(moimEntity.getMoimNCount())
                        .memberId(moimEntity.getMemberId())
                        .moimKakao(moimEntity.getMoimKakao())
                        .categoryNum(moimEntity.getCategoryNum())
                        .moimImg(moimEntity.getMoimImg())
                        .moimProfile(moimEntity.getMoimProfile())
                        .moimDate(moimEntity.getMoimDate())
                        .businessNum(moimEntity.getBusinessNum())
                        .taskNum(moimEntity.getTaskNum())
                        .themeNum(moimEntity.getThemeNum())
                        .classPrice(moimEntity.getClassPrice())
                        .moimOrClass(moimEntity.getMoimOrClass())
                        .build();
            }).collect(Collectors.toList());
            String categoryName = categoryEntityList.stream().filter(category -> category.getCategoryNum() == categoryNum).findFirst().get().getCategoryName();
            return new ResCategoryMoim(member, roleList, categoryName, categoryList, categoryMoimList);
        }
    }
}
