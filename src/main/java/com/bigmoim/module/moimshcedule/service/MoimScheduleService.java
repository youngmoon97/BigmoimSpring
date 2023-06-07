package com.bigmoim.module.moimshcedule.service;


import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.category.repository.CategoryRepository;
import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.repository.MemberRepository;
import com.bigmoim.module.moim.entity.MoimEntity;
import com.bigmoim.module.moim.repository.MoimRepository;
import com.bigmoim.module.moimshcedule.dto.MoimScheduleDTO;
import com.bigmoim.module.moimshcedule.entity.MoimScheduleEntity;
import com.bigmoim.module.moimshcedule.repository.MoimScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MoimScheduleService {
    private final MoimScheduleRepository moimScheduleRepository;
    private final CategoryRepository categoryRepository;
    private final MoimRepository moimRepository;
    private final MemberRepository memberRepository;

    public MoimScheduleDTO.ResMoimSchedule getMoimSchedule(CustomUserDetails customUserDetails) {
        List<MoimScheduleEntity> moimScheduleEntityList = moimScheduleRepository.allMoimSchedule();
        List<CategoryEntity> categoryEntityList = categoryRepository.categoryList();
        List<MoimEntity> moimEntityList = moimRepository.allMoim();
        List<MemberEntity> memberEntityList = memberRepository.getMemberList();
        return MoimScheduleDTO.ResMoimSchedule.fromEntityList(
                customUserDetails.getMemberEntity(),
                moimScheduleEntityList,
                categoryEntityList,
                moimEntityList,
                memberEntityList);
    }
}
