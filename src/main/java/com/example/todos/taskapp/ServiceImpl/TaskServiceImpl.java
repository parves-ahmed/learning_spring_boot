package com.example.todos.taskapp.ServiceImpl;

import com.example.todos.taskapp.Dto.TaskDto;
import com.example.todos.taskapp.Model.TaskModel;
import com.example.todos.taskapp.Repository.TaskRepository;
import com.example.todos.taskapp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void createTask(TaskDto taskDto) {
        TaskModel task = new TaskModel();
        task.setTaskName(taskDto.getTaskName());
        taskRepository.save(task);
    }

    @Override
    public Iterable<TaskModel> getAllTask() {
        return taskRepository.findAll();
    }
}
