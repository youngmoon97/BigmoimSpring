package com.bigmoim.module.task.dto;

import com.bigmoim.module.category.entity.CategoryEntity;
import com.bigmoim.module.task.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class TaskDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResBasic {

        private List<Task> TaskList;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Task {
            Integer taskNum;
            String taskName;
        }
        public static ResBasic fromEntityList(List<TaskEntity> taskEntityList){
            List<Task> taskList =  taskEntityList.stream().map(taskEntity -> {
                return Task.builder()
                        .taskNum(taskEntity.getTaskNum())
                        .taskName(taskEntity.getTaskName())
                        .build();
            }).collect(Collectors.toList());
            return new ResBasic(taskList);
        }
    }
}
