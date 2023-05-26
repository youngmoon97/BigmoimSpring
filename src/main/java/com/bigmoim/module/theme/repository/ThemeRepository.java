package com.bigmoim.module.theme.repository;

import com.bigmoim.module.task.entity.TaskEntity;
import com.bigmoim.module.theme.entity.ThemeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ThemeRepository {
    List<ThemeEntity> themeList();
}
