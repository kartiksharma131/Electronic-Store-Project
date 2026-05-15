package com.electronic.store.electronicstore.service.impl;

import com.electronic.store.electronicstore.dtos.UserDto;
import com.electronic.store.electronicstore.entity.User;
import com.electronic.store.electronicstore.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.electronic.store.electronicstore.repository.UserRepository;
import com.electronic.store.electronicstore.service.interfaces.UserService;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    UserRepository userRepository;

    public UserServiceImpl(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto){
        User user = dtoToEntity(userDto);
        UUID uuid  = UUID.randomUUID();
        user.setUserId(uuid.toString());
        User savedUser = userRepository.save(user);
        return entityToDto(savedUser);
    }

    @Override
    public void updateUser(UserDto userDto, String userId) {
        User user = dtoToEntity(userDto);
        userRepository.updateUser(user,userId);
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUsers(int pageNumber, int pageSize,String sortBy, String sortByDir) {

        //create a sorting object and pass the coplumn name you want to sort
        Sort sort = Sort.by(sortBy);

        //create a pageable object and pass the sort object for sorting here
        Pageable pageable = (Pageable) PageRequest.of(pageNumber,pageSize,sort);
        Page<User> page = userRepository.findAll((PageRequest) pageable);
        List<User> users = page.getContent();
        if(users.isEmpty()){
            throw new ResourceNotFoundException("No users found");
        }
        return users.stream().map(this::entityToDto).toList();
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+userId));
        return entityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        if(user==null){
            throw new ResourceNotFoundException("User not found with email: "+userEmail);
        }
        return entityToDto(user);
    }

    @Override
    public boolean userExists(String id) {
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
