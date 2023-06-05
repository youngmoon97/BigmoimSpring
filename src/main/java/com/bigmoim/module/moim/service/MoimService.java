package com.bigmoim.module.moim.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.business.entity.BusinessEntity;
import com.bigmoim.module.business.repository.BusinessRepository;
import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.category.repository.CategoryRepository;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.member.repository.MemberRepository;
import com.bigmoim.module.member.repository.RoleRepository;
import com.bigmoim.module.moim.dto.MainDTO;
import com.bigmoim.module.moim.dto.MoimDTO;
import com.bigmoim.module.moim.dto.MoimDetailDTO;
import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.moim.repository.MoimRepository;
import com.bigmoim.module.moimshcedule.entity.MoimScheduleEntity;
import com.bigmoim.module.moimshcedule.repository.MoimScheduleRepository;
import com.bigmoim.module.schedulejoin.entity.ScheduleJoinEntity;
import com.bigmoim.module.schedulejoin.repository.SchedulejoinRepostory;
import com.bigmoim.module.task.entity.TaskEntity;
import com.bigmoim.module.task.repository.TaskRepository;
import com.bigmoim.module.theme.entity.ThemeEntity;
import com.bigmoim.module.theme.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MoimService {
    private final MoimRepository moimRepository;
    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;
    private final MemberRepository memberRepository;
    private final BusinessRepository businessRepository;
    private final TaskRepository taskRepository;
    private final ThemeRepository themeRepository;
    private final MoimScheduleRepository moimScheduleRepository;
    private final SchedulejoinRepostory schedulejoinRepostory;

    public MainDTO.ResBasic getMainList(CustomUserDetails customUserDetails) {
        MemberEntity memberDetail = memberRepository.getMember(customUserDetails.getUsername());
        List<MoimEntity> classList = moimRepository.classList(memberDetail.getMemberAddr());
        List<MoimEntity> allclassList = moimRepository.allclassList();
        List<MoimEntity> allMoimList = moimRepository.allMoim();
        List<BusinessEntity> businessEntityList = businessRepository.businessList();
        List<TaskEntity> taskEntityList = taskRepository.taskList();
        List<ThemeEntity> themeEntityList = themeRepository.themeList();
        List<MoimEntity> newMoimList = moimRepository.newMoimList();
        List<MoimEntity> recoMoimList = moimRepository.areaList(memberDetail.getMemberAddr());
        List<MoimEntity> joinMoimList = moimRepository.joinMoimList(customUserDetails.getUsername());
        List<MoimEntity> businessMoimList = moimRepository.businessList(memberDetail.getBusinessNum());
        List<MoimEntity> taskMoimList = moimRepository.taskList(memberDetail.getTaskNum());
        List<MoimEntity> themeMoimList = moimRepository.themeList(memberDetail.getThemeNum());
        List<MoimEntity> myMoimEntityList = moimRepository.myMoimList(customUserDetails.getUsername());
        List<CategoryEntity> categoryEntityList = categoryRepository.categoryList();

        return MainDTO.ResBasic.fromEntityList(
                classList,
                allMoimList,
                customUserDetails.getMemberEntity(),
                customUserDetails.getRoleEntityList(),
                categoryEntityList,
                newMoimList,
                allclassList,
                recoMoimList,
                joinMoimList,
                businessMoimList,
                taskMoimList,
                themeMoimList,
                businessEntityList,
                taskEntityList,
                themeEntityList,
                myMoimEntityList);
    }
    // 모임 디테일
    public MoimDetailDTO.ResMoimDetail getMoimDetail(CustomUserDetails customUserDetails, Integer moimNum) {
        MoimEntity moimEntity = moimRepository.findByMoimNum(moimNum);
        List<RoleEntity> moimMemberEntity = roleRepository.moimMember(moimNum);
        List<MoimScheduleEntity> moimScheduleEntityList = moimScheduleRepository.moimSchedule(moimNum);
        List<ScheduleJoinEntity> scheduleJoinEntityList = schedulejoinRepostory.moimschedulejoin(moimNum);
        List<MemberEntity> memberEntityList = memberRepository.getMemberList();
        List<CategoryEntity> categoryEntityList = categoryRepository.categoryList();
        return MoimDetailDTO.ResMoimDetail.toMoimDetail(
                moimEntity,
                customUserDetails.getMemberEntity(),
                memberEntityList,
                customUserDetails.getRoleEntityList(),
                moimMemberEntity,
                moimScheduleEntityList,
                scheduleJoinEntityList,
                categoryEntityList
        );
    }
    // 카테고리 별 모임
    public MainDTO.ResCategoryMoim getCategoryMoim(Integer categoryNum, CustomUserDetails customUserDetails) {
        List<CategoryEntity> categoryEntityList = categoryRepository.categoryList();
        List<MoimEntity> categoryMoimList = moimRepository.categoryList(categoryNum);
        return MainDTO.ResCategoryMoim.fromEntityList(customUserDetails.getMemberEntity(), customUserDetails.getRoleEntityList(),
                categoryEntityList, categoryMoimList, categoryNum);
    }
//    public HttpEntity<?> allMoim(){
//        List<MoimEntity> moimEntityList = moimRepository.allMoim();
//        return new ResponseEntity<>(
//                ResDTO.builder()
//                        .code(0)
//                        .message("모든 모임 리스트 조회에 성공하였습니다.")
//                        .data(MainDTO.ResBasic.fromEntityList(moimEntityList).getMoimList())
//                        .build(),
//                HttpStatus.OK);
//    }

    public HttpEntity<?> findByMoimNum(int moimNum) {
        MoimEntity findByMoimNumEntity = moimRepository.findByMoimNum(moimNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모임 번호로 모임을 찾았습니다.")
                        .data(findByMoimNumEntity)
                        .build(),
                HttpStatus.OK);
    }


//    public HttpEntity<?> searchMoimList(String moimName){
//        List<MoimEntity> searchMoimEntityList = moimRepository.searchMoimList(moimName);
//        return new ResponseEntity<>(
//                ResDTO.builder()
//                        .code(0)
//                        .message("검색한 모임을 찾았습니다.")
//                        .data(MainDTO.ResBasic.fromEntityList(searchMoimEntityList).getMoimList())
//                        .build(),
//                HttpStatus.OK);
//    }


    public HttpEntity<?> moimUpdate(int moimNum) {
        Integer moimUpdateResult = moimRepository.moinUpdate(moimNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모임정보를 수정했습니다.")
                        .data(moimUpdateResult)
                        .build(),
                HttpStatus.OK);
    }

    public HttpEntity<?> moimDelete(int moimNum) {
        Integer moimDeleteResult = moimRepository.moimDelete(moimNum);
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("모임을 제거했습니다.")
                        .data(moimDeleteResult)
                        .build(),
                HttpStatus.OK);
    }

}
