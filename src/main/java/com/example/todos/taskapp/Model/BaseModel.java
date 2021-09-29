package com.example.todos.taskapp.Model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseModel implements Serializable {
    private static final Long serialVersionUID = 250796155405292021L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID uuid;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updatedAt;

    private boolean isDeleted;

    @PrePersist
    public void setOnCreate(){
        this.uuid = UUID.randomUUID();
        this.setCreatedAt(Calendar.getInstance());
        this.setUpdatedAt(Calendar.getInstance());
        this.setDeleted(false);
    }

    @PreUpdate
    public void setOnUpdate(){
        this.setUpdatedAt(Calendar.getInstance());
    }
}
