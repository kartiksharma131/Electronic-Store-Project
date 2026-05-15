package com.electronic.store.electronicstore.service.interfaces;

import com.electronic.store.electronicstore.dtos.UserDto;

import java.util.List;

public interface UserService {
    //create
    UserDto createUser(UserDto userDto);

    //update
    void updateUser(UserDto userDto,String userId);

    //delete
    void delete(String userId);

    //get all Users
    List<UserDto> getAllUsers(int pageNumber,int  pageSize, String sortBy, String sortByDir);

    //get single user by ID
    UserDto getUserById(String userId);

    //get single user by email
    UserDto getUserByEmail(String userEmail);

    //search user
    boolean userExists(String id);

    //other features
}
