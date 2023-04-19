package com.techkernal.springbootjwt.repository;

import com.techkernal.springbootjwt.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
