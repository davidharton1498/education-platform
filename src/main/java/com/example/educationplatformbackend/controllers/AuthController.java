package com.example.educationplatformbackend.controllers;

import com.example.educationplatformbackend.entities.User;
import com.example.educationplatformbackend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AuthController {

    private UserService userService;
    //save operation
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    //read operation
    @GetMapping("/users")
    public List<User> fetchUserlist(){
        return userService.fetchUserList();
    }
    //update operation
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Long id){
        return userService.updateUser(user,id);
    }
    //delete operation
    @DeleteMapping("/users/{id}")
    public String removeUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return "The user has been deleted successfully";
    }
}
