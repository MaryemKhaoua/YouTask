package com.example.youTask.service;

import com.example.youTask.bean.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User createUser(User user);
    public Optional<User> getUserById(Long id);
    public List<User> getAllUsers();
    public User updateUser(User user);
    public void deleteUser(Long id);
    public List<User> searchUsersByName(String name);
}
