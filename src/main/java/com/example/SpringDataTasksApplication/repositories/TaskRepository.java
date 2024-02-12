package com.example.SpringDataTasksApplication.repositories;

import com.example.SpringDataTasksApplication.model.Task;
import com.example.SpringDataTasksApplication.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findTasksByStatus(TaskStatus status);
}
