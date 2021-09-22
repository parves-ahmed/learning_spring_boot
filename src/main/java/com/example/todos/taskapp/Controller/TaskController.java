package com.example.todos.taskapp.Controller;

import com.example.todos.taskapp.Dto.TaskDto;
import com.example.todos.taskapp.Model.TaskModel;
import com.example.todos.taskapp.Repository.TaskRepository;
import com.example.todos.taskapp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskDto));
    }

    @GetMapping(path = "/all")
    public ResponseEntity getAllTask(){
        return ResponseEntity.ok().body(taskService.getAllTask());
    }
}
