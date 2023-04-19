package com.techkernal.springbootjwt.repository;

import com.techkernal.springbootjwt.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByUsersId(long userId);
}
