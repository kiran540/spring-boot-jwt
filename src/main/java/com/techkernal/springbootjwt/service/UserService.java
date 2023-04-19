package com.techkernal.springbootjwt.service;

import com.techkernal.springbootjwt.payload.UserDto;

public interface UserService {
    public UserDto createUser(UserDto userDto);
}
