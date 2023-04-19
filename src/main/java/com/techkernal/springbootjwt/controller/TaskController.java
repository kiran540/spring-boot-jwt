package com.techkernal.springbootjwt.controller;


import com.techkernal.springbootjwt.exception.APIException;
import com.techkernal.springbootjwt.exception.TaskNotFound;
import com.techkernal.springbootjwt.exception.UserNotFound;
import com.techkernal.springbootjwt.payload.TaskDto;
import com.techkernal.springbootjwt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/{userid}/tasks")
    public ResponseEntity<TaskDto> saveTask(@PathVariable(name = "userid") long userid, @RequestBody TaskDto taskDto) throws UserNotFound {
        return new ResponseEntity<>(taskService.saveTask(userid,taskDto),HttpStatus.CREATED);
    }

    @GetMapping("/{userid}/tasks")
    public ResponseEntity<List<TaskDto>> getAllTask(@PathVariable(name = "userid") long userid) throws UserNotFound {
        return new ResponseEntity<>(taskService.getAllTasks(userid),HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> getAllTask(@PathVariable(name = "userId") long userId,@PathVariable(name = "taskId") long taskId) throws UserNotFound, TaskNotFound, APIException {
        return new ResponseEntity<>(taskService.getTask(userId,taskId),HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDto> deleteTask(@PathVariable(name = "userId") long userId,@PathVariable(name = "taskId") long taskId) throws UserNotFound, TaskNotFound, APIException {
        return new ResponseEntity<>(taskService.deleteTask(userId,taskId),HttpStatus.CREATED);
    }
}
