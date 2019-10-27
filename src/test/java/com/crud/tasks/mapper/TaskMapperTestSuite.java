package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Task 1", "Content 1");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals("Task 1", task.getTitle());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Task 1", "Content 1");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals("Task 1", taskDto.getTitle());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L,"Task 1","Content 1"));
        tasks.add(new Task(2L,"Task 2","Content 2"));
        tasks.add(new Task(3L,"Task 3","Content 3"));
        tasks.add(new Task(4L,"Task 4","Content 4"));
        tasks.add(new Task(5L,"Task 5","Content 5"));
        tasks.add(new Task(6L,"Task 6","Content 6"));

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(6, taskDtoList.size());
        assertEquals("Task 4", taskDtoList.get(3).getTitle());
    }
}
