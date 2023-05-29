package com.bigmoim.module.member.service;

import com.bigmoim.module.business.entity.BusinessEntity;
import com.bigmoim.module.business.repository.BusinessRepository;
import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.category.repository.CategoryRepository;
import com.bigmoim.module.member.dto.AuthDTO;
import com.bigmoim.module.task.entity.TaskEntity;
import com.bigmoim.module.task.repository.TaskRepository;
import com.bigmoim.module.theme.entity.ThemeEntity;
import com.bigmoim.module.theme.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final CategoryRepository categoryRepository;
    private final BusinessRepository businessRepository;
    private final TaskRepository taskRepository;
    private final ThemeRepository themeRepository;

    public AuthDTO.ResSignup getAllList(){
        List<CategoryEntity> categoryEntityList = categoryRepository.categoryList();
        List<BusinessEntity> businessEntityList = businessRepository.businessList();
        List<TaskEntity> taskEntities = taskRepository.taskList();
        List<ThemeEntity> themeEntities = themeRepository.themeList();

        return AuthDTO.ResSignup.fromAllEntityList(categoryEntityList,businessEntityList,taskEntities,themeEntities);
    }
}
