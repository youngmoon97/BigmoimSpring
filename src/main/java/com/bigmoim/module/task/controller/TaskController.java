package com.bigmoim.module.task.controller;

import com.bigmoim.module.category.service.CategoryService;
import com.bigmoim.module.task.dto.TaskDTO;
import com.bigmoim.module.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/taskList")
public class TaskController {
    private final TaskService taskService;
    @GetMapping
    public String getTaskPage(Model model) {
        TaskDTO.ResBasic resDto = taskService.getTaskList();
        model.addAttribute("resDto", resDto);
        return "/main/taskList";
    }

}
