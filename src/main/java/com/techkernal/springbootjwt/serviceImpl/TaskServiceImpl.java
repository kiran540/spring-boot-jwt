package com.techkernal.springbootjwt.serviceImpl;

import com.techkernal.springbootjwt.entity.Task;
import com.techkernal.springbootjwt.entity.Users;
import com.techkernal.springbootjwt.exception.APIException;
import com.techkernal.springbootjwt.exception.TaskNotFound;
import com.techkernal.springbootjwt.exception.UserNotFound;
import com.techkernal.springbootjwt.payload.TaskDto;
import com.techkernal.springbootjwt.repository.TaskRepository;
import com.techkernal.springbootjwt.repository.UserRepository;
import com.techkernal.springbootjwt.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public TaskDto saveTask(long userId, TaskDto taskDto) throws UserNotFound {
        Users users = userRepository.findById(userId).orElseThrow(()->new UserNotFound(String.format("User Id %d not found",userId)));
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUsers(users);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask,TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(long userId) throws UserNotFound {
        userRepository.findById(userId).orElseThrow(()->new UserNotFound(String.format("User Id %d not found",userId)));
        List<Task> tasks = taskRepository.findAllByUsersId(userId);
        List<TaskDto> taskDto = tasks.stream().map(x->modelMapper.map(x,TaskDto.class)).collect(Collectors.toList());
        return taskDto;
    }

    @Override
    public TaskDto getTask(long userId, long taskId) throws UserNotFound, TaskNotFound, APIException {
        Users users = userRepository.findById(userId).orElseThrow(()->new UserNotFound(String.format("User Id %d not found",userId)));
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFound(String.format("Task Id %d not found",taskId)));
        if(users.getId() != task.getUsers().getId()){
            throw new APIException("Invalid Operation");
        }
        return modelMapper.map(task,TaskDto.class);
    }

    @Override
    public TaskDto deleteTask(long userId, long taskId) throws UserNotFound, TaskNotFound, APIException {
        Users users = userRepository.findById(userId).orElseThrow(()->new UserNotFound(String.format("User Id %d not found",userId)));
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFound(String.format("Task Id %d not found",taskId)));
        if(users.getId() != task.getUsers().getId()){
            throw new APIException("Invalid Operation");
        }
        taskRepository.deleteById(taskId);
        return modelMapper.map(task,TaskDto.class);
    }
}
