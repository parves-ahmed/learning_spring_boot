package com.example.todos.taskapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel extends BaseModel{
    private static final Long serialVersionUID = 202129250796540515L;
    private String taskName;
    private String taskDescription;
}
