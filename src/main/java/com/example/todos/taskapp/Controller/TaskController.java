package com.example.todos.taskapp.Controller;

import com.example.todos.taskapp.Dto.TaskDto;
import com.example.todos.taskapp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskDto){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskDto));
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<TaskDto>> allTask(){
        return ResponseEntity.ok().body(taskService.getAllTask());
    }

    @GetMapping(path = "getById/{id}")
    public ResponseEntity<TaskDto> taskById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskById(id));
    }

    @PutMapping(path = "/edit/{id}")
    public ResponseEntity<?> updateTaskByPut(@PathVariable("id") Long taskId, @RequestBody TaskDto taskDto){
        taskDto.setId(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.createTask(taskDto));
    }

    @PatchMapping(path = "/patch/{id}")
    public ResponseEntity<?> updateTaskByPatch(@PathVariable("id") Long taskId, @RequestBody TaskDto taskDto){
        taskDto.setId(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.createTask(taskDto));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTaskByMap(@PathVariable("id") Long id, @RequestBody Map<String, Object>updateMap){
        boolean result = taskService.updateTask(id, updateMap);
        if(result == true){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
        }
    }

    @DeleteMapping(path = "/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long taskId){
        TaskDto taskDto = taskService.getTaskById(taskId);
//        Todo: Update status
        taskDto.setDeleted(true);
        return ResponseEntity.ok(taskService.delete(taskDto));
    }
}
