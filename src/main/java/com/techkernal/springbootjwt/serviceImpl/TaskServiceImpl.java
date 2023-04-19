package com.techkernal.springbootjwt.serviceImpl;

import com.techkernal.springbootjwt.entity.Task;
import com.techkernal.springbootjwt.entity.Users;
import com.techkernal.springbootjwt.payload.TaskDto;
import com.techkernal.springbootjwt.repository.TaskRepository;
import com.techkernal.springbootjwt.repository.UserRepository;
import com.techkernal.springbootjwt.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public TaskDto saveTask(long userId, TaskDto taskDto) {
        Users users = userRepository.findById(userId).get();
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUsers(users);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask,TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(long userId) {
        return null;
    }
}
