package com.example.SpringDataTasksApplication.services;

import com.example.SpringDataTasksApplication.model.Task;
import com.example.SpringDataTasksApplication.repositories.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;

    @Test
    @DisplayName("addTaskTest")
    public void addTaskUnitTest(){
        Task task = new Task();
        task.setDescription("Test task");

        given(taskRepository.save(task)).willReturn(task);

        Task resultTask = taskService.addTask(task);

        verify(taskRepository).save(task);
        assertEquals("message", resultTask.getDescription(),"Test task");
    }


}
