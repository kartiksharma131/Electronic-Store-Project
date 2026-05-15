package com.electronic.store.electronicstore.controllers;

import com.electronic.store.electronicstore.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.electronic.store.electronicstore.service.interfaces.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserDto registerUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers(
            @RequestParam(value="pageNumber", defaultValue ="0", required = false ) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "0",required = false) int pageSize,
            @RequestParam(value="sortBy", defaultValue ="name", required = false ) String sortBy,
            @RequestParam(value = "sortByDir", defaultValue = "ASC",required = false) String sortByDir){
        return userService.getAllUsers(pageNumber,pageSize,sortBy,sortByDir);
    }

    @GetMapping("/getUsersbyEmail/{email}")
    public UserDto getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable String id){
        userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@Valid  @RequestBody UserDto userDto, @PathVariable String id){
        userService.updateUser(userDto,id);
    }

    @GetMapping("/exists/{id}")
    public boolean userExists(@PathVariable String id){
        return userService.userExists(id);
    }


}
