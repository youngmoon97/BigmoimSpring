package com.bigmoim.module.task.repository;

import com.bigmoim.module.task.entity.TaskEntity;

import java.util.List;

public interface TaskRepository {
    List<TaskEntity> taskList();

}
