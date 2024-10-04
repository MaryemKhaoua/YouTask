package com.example.youTask.service.impl;

import com.example.youTask.bean.User;
import com.example.youTask.repository.UserRepository;
import com.example.youTask.repository.impl.UserRepositoryImpl;
import com.example.youTask.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.update(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> searchUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public void close() {
        if (userRepository instanceof UserRepositoryImpl) {
            ((UserRepositoryImpl) userRepository).close();
        }
    }
}
