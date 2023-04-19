package com.techkernal.springbootjwt.payload;

import com.techkernal.springbootjwt.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private long id;
    private String taskname;
    private Users users;
}
