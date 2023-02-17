package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.User;

import java.util.List;


public interface UserService {
    //save operation
    User save(UserRegistrationDto userRegistrationDto);

    User saveUser(User user);

    List<User> fetchUserList();

    void deleteUserById(Long id);

    User updateUser(User user, Long id);
}
