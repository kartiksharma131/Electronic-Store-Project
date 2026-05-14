package com.electronic.store.electronicstore.controllers;

import com.electronic.store.electronicstore.dtos.UserDto;
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
    public UserDto registerUser(@RequestBody UserDto userDto) {
        // Logic to register a new user
        return userService.createUser(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUsersbyEmail/{email}")
    public UserDto getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@RequestBody UserDto userDto,@PathVariable int id){
        userService.updateUser(userDto,id);
    }

    @GetMapping("/exists/{id}")
    public boolean userExists(@PathVariable int id){
        return userService.userExists(id);
    }


}
