package com.todo.service;

import com.todo.dto.CreateTaskDto;
import com.todo.dto.TaskDto;
import com.todo.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskDto> findTasksByUser();
    TaskDto save(CreateTaskDto taskDto);
    void deleteById(Long id);
    void update(TaskDto taskDto);
}
