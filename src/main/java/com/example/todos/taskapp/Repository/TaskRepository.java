package com.example.todos.taskapp.Repository;

import com.example.todos.taskapp.Model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Integer> {
}
