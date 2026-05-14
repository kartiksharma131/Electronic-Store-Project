package com.electronic.store.electronicstore.service.interfaces;

import com.electronic.store.electronicstore.dtos.UserDto;

import java.util.List;

public interface UserService {
    //create
    UserDto createUser(UserDto userDto);

    //update
    void updateUser(UserDto userDto,int userId);

    //delete
    void delete(int userId);

    //get all Users
    List<UserDto> getAllUsers();

    //get single user by ID
    UserDto getUserById(int userId);

    //get single user by email
    UserDto getUserByEmail(String userEmail);

    //search user
    boolean userExists(int id);

    //other features
}
