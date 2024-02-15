package com.example.SpringDataTasksApplication.services;

import com.example.SpringDataTasksApplication.model.Task;
import com.example.SpringDataTasksApplication.model.TaskStatus;
import com.example.SpringDataTasksApplication.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    /**
     * Репозиторий для связи с БД
     */
    private final TaskRepository repository;

    /**
     * Добавить задачу в репозиторий
     * @param task задача
     * @return добавденная задача
     */
    public Task addTask(Task task){
        return repository.save(task);
    }

    /**
     * Получение всех задач
     * @return список задач
     */
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    /**
     * Получение задач по статаусу
     * @param status статус задач
     * @return список задач
     */
    public List<Task> getTasksByStatus(TaskStatus status){
        return repository.findTasksByStatus(status);
    }

    /**
     * Обновление задаачи
     * @param id ID задачи
     * @param task задача
     * @return обновленная задача
     */
    public Task updateTaskStatus(Long id, Task task){
        task.setId(id);
        return repository.save(task);
    }

    /**
     * Удаление задачи
     * @param id ID задачи
     */
    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
