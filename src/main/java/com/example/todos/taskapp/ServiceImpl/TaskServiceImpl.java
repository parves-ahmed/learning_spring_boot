package com.example.todos.taskapp.ServiceImpl;

import com.example.todos.taskapp.Dto.TaskDto;
import com.example.todos.taskapp.Model.TaskModel;
import com.example.todos.taskapp.Repository.TaskRepository;
import com.example.todos.taskapp.Service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper){
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public TaskDto createTask(TaskDto taskDto) {
        return this.mapToDto(taskRepository.save(mapToModel(taskDto)));
    }

    @Override
    public List<TaskDto> getAllTask() {
        return taskRepository.findAll().stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public TaskModel mapToModel(TaskDto dto){
        TaskModel model = modelMapper.map(dto, TaskModel.class);
        return model;
    }
    public TaskDto mapToDto(TaskModel model){
        TaskDto dto = modelMapper.map(model, TaskDto.class);
        return dto;
    }
}
