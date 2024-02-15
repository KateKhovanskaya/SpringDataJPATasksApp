package com.example.SpringDataTasksApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="tasks")

public class Task {
    /**
     * ID задачи
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * Описание задачи
     */
    @Column(nullable = false)
    private String description;
    /**
     * Статус задачи
     */
    @Enumerated
    private TaskStatus status = TaskStatus.NOT_STARTED;
    /**
     * Дата и время создания задачи
     */
    private LocalDateTime creatingData = LocalDateTime.now();

}

