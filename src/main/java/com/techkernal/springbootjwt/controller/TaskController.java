package com.techkernal.springbootjwt.controller;


import com.techkernal.springbootjwt.payload.TaskDto;
import com.techkernal.springbootjwt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/{userid}/tasks")
    public ResponseEntity<TaskDto> saveTask(@PathVariable(name = "userid") long userid, @RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.saveTask(userid,taskDto),HttpStatus.CREATED);
    }

}
