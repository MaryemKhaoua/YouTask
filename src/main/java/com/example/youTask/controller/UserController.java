package com.example.youTask.controller;

import com.example.youTask.bean.User;
import com.example.youTask.service.UserService;
import com.example.youTask.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserServiceImpl();
    }

    public void createUser(User user) {
        userService.createUser(user);
    }

    public void displayUserById(Long id) {
        Optional<User> user = userService.getUserById(id);
        user.ifPresentOrElse(
                u -> System.out.println("User found: " + u),
                () -> System.out.println("User not found.")
        );
    }

    public void displayAllUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(user -> System.out.println("User: " + user));
    }

    public void updateUser(User user) {
        userService.updateUser(user);
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    public void searchUsersByName(String name) {
        List<User> users = userService.searchUsersByName(name);
        users.forEach(user -> System.out.println("Found user: " + user));
    }

    public void close() {
        ((UserServiceImpl) userService).close();
    }
}
