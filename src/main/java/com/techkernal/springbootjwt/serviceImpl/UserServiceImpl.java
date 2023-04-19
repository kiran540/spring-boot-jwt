package com.techkernal.springbootjwt.serviceImpl;

import com.techkernal.springbootjwt.entity.Users;
import com.techkernal.springbootjwt.payload.UserDto;
import com.techkernal.springbootjwt.repository.UserRepository;
import com.techkernal.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Users savedUser = userRepository.save(userDtoToEntity(userDto));
        return userEntityToDto(savedUser);
    }

    private Users userDtoToEntity(UserDto userDto){
        Users user = new Users();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return user;
    }

    private UserDto userEntityToDto(Users user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
