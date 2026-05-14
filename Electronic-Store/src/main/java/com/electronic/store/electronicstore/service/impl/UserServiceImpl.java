package com.electronic.store.electronicstore.service.impl;

import com.electronic.store.electronicstore.dtos.UserDto;
import com.electronic.store.electronicstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.electronic.store.electronicstore.repository.UserRepository;
import com.electronic.store.electronicstore.service.interfaces.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    UserRepository userRepository;

    public UserServiceImpl(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto){
        User user = dtoToEntity(userDto);
        User savedUser = userRepository.save(user);
        return entityToDto(savedUser);
    }

    @Override
    public void updateUser(UserDto userDto, int userId) {
        User user = dtoToEntity(userDto);
        userRepository.updateUser(user,userId);
    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::entityToDto).toList();
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found with id: "+userId));
        return entityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        return entityToDto(user);
    }

    @Override
    public boolean userExists(int id) {
        return userRepository.existsById(id);
    }

    private User dtoToEntity(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setGender(userDto.getGender());
        user.setRole(userDto.getRole());
        return user;
    }

    private UserDto entityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setGender(user.getGender());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
