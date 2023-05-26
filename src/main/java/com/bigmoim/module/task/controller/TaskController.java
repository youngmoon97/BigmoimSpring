package com.bigmoim.module.task.controller;

import com.bigmoim.module.category.service.CategoryService;
import com.bigmoim.module.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/taskList")
public class TaskController {
    private final TaskService taskService;
    @GetMapping
    public HttpEntity<?> getTaskList(){
        log.info("직무 리스트를 가져옵니다.");
        return taskService.taskList();
    }

}
