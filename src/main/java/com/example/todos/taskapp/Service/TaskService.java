package com.example.todos.taskapp.Service;

import com.example.todos.taskapp.Dto.TaskDto;
import com.example.todos.taskapp.Model.TaskModel;

import java.util.List;
import java.util.Map;

public interface TaskService {
    public abstract TaskDto createTask(TaskDto taskDto);
    public abstract List<TaskDto> getAllTask();
    public abstract TaskDto getTaskById(Long id);
    public abstract TaskDto delete(TaskDto taskDto);
    public abstract boolean updateTask(Long id, Map<String, Object>update);
}
