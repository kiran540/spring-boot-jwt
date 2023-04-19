package com.techkernal.springbootjwt.service;

import com.techkernal.springbootjwt.payload.TaskDto;

import java.util.List;

public interface TaskService {
    public TaskDto saveTask(long userId, TaskDto taskDto);
    public List<TaskDto> getAllTasks(long userId);
}
