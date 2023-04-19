package com.techkernal.springbootjwt.service;

import com.techkernal.springbootjwt.exception.APIException;
import com.techkernal.springbootjwt.exception.TaskNotFound;
import com.techkernal.springbootjwt.exception.UserNotFound;
import com.techkernal.springbootjwt.payload.TaskDto;

import java.util.List;

public interface TaskService {
    public TaskDto saveTask(long userId, TaskDto taskDto) throws UserNotFound;
    public List<TaskDto> getAllTasks(long userId) throws UserNotFound;
    public TaskDto getTask(long userId,long taskId) throws UserNotFound, TaskNotFound, APIException;
    public TaskDto deleteTask(long userId,long taskId) throws UserNotFound, TaskNotFound, APIException;

}
