package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.controllers.MainController;
import com.example.educationplatformbackend.entities.Role;
import com.example.educationplatformbackend.entities.User;
import com.example.educationplatformbackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    private MainController mainController;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user=new User(userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),userRegistrationDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> fetchUserList() {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public User updateUser(User user, Long id) {
        return null;
    }

}
