package com.example.SpringDataTasksApplication.controllers;

import com.example.SpringDataTasksApplication.model.Task;
import com.example.SpringDataTasksApplication.model.TaskStatus;
import com.example.SpringDataTasksApplication.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    /**
     * Сервис, управляющий задачами
     */
    private final TaskService taskService;

    /**
     * Получение всех задач
     * @return список задач
     */
    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    /**
     * Добавление задачи
     * @param task задача
     * @return добавленная задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    /**
     * Получение задач определенного статуча
     * @param status статус задач
     * @return список задач
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }

    /**
     * Обновление задачи
     * @param id ID задачи
     * @param task обновленная задача
     * @return обновленная задача
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return taskService.addTask(task);
    }

    /**
     * Удаление задачи
     * @param id ID задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
