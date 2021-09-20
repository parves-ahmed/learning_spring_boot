package com.example.todos.taskapp.Service;

import com.example.todos.taskapp.Dto.TaskDto;
import com.example.todos.taskapp.Model.TaskModel;

public interface TaskService {
    public abstract void createTask(TaskDto taskDto);
    public abstract Iterable<TaskModel> getAllTask();
}
