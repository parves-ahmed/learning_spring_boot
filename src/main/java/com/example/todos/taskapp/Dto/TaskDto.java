package com.example.todos.taskapp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto extends CommonDto{
    String taskName;
    String taskDescription;
}
