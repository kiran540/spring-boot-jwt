package com.techkernal.springbootjwt.repository;

import com.techkernal.springbootjwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
