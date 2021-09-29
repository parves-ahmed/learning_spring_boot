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
import java.util.Map;
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
        System.out.println("taskDto = " + taskDto);
        return this.mapToDto(taskRepository.save(this.mapToModel(taskDto)));
    }

    @Override
    public List<TaskDto> getAllTask() {
        return taskRepository.findAll().stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskById(Long id){
        return this.mapToDto(taskRepository.findById(id).get());
    }

    @Override
    @Transactional
    public boolean updateTask(Long id, Map<String, Object> update){
        boolean result = false;
        try{
            System.out.println("id = " + id);
            System.out.println("update = " +update.get("taskName").toString());
            TaskModel task = taskRepository.findById(id).get();
            task.setTaskName(update.get("taskName").toString());
            taskRepository.save(task);
            result = true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public TaskDto delete(TaskDto taskDto){
        return this.mapToDto(taskRepository.save(this.mapToModel(taskDto)));
    }

    public TaskModel mapToModel(TaskDto dto){
        TaskModel model = new TaskModel();
        modelMapper.map(dto, model);
        return model;
    }
    public TaskDto mapToDto(TaskModel model){
        TaskDto dto = modelMapper.map(model, TaskDto.class);
        return dto;
    }
}
