package com.bigmoim.module.task.repository;

import com.bigmoim.module.task.entity.TaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TaskRepository {
    List<TaskEntity> taskList();
}
