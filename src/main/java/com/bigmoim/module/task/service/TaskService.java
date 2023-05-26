package com.bigmoim.module.task.service;

import com.bigmoim.common.dto.ResDTO;
import com.bigmoim.module.category.dto.CategoryDTO;
import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.category.repository.CategoryRepository;
import com.bigmoim.module.task.dto.TaskDTO;
import com.bigmoim.module.task.entity.TaskEntity;
import com.bigmoim.module.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {
    private final TaskRepository taskRepository;

    public HttpEntity<?> taskList(){
        List<TaskEntity> taskEntityList = taskRepository.taskList();
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(0)
                        .message("직무 리스트 조회에 성공하였습니다.")
                        .data(TaskDTO.ResBasic.fromEntityList(taskEntityList).getTaskList())
                        .build(),
                HttpStatus.OK);
    }
}
