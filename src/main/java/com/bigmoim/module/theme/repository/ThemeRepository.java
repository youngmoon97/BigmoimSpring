package com.bigmoim.module.theme.repository;

import com.bigmoim.module.task.entity.TaskEntity;
import com.bigmoim.module.theme.entity.ThemeEntity;

import java.util.List;

public interface ThemeRepository {
    List<ThemeEntity> themeList();
}
