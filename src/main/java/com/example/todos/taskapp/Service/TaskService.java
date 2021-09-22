package com.example.todos.taskapp.Service;

import com.example.todos.taskapp.Dto.TaskDto;
import com.example.todos.taskapp.Model.TaskModel;

import java.util.List;

public interface TaskService {
    public abstract TaskDto createTask(TaskDto taskDto);
    public abstract List<TaskDto> getAllTask();
}
