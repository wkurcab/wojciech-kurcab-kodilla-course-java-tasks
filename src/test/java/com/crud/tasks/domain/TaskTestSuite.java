package com.crud.tasks.domain;

import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTestSuite {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testSaveEntityTaskToDatabase() {
        //Given
        Task task = new Task();
        //When
        taskRepository.save(task);
        long id = task.getId();
        Optional<Task> readOrder = taskRepository.findById(id);
        //Then
        assertTrue(readOrder.isPresent());
        //CleanUp
        taskRepository.delete(task);
    }
}