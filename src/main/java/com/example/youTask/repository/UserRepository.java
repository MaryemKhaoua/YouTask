package com.example.youTask.repository;

import com.example.youTask.bean.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User save(User user);
    public Optional<User> findById(Long id);
    public List<User> findAll();
    public User update(User user);
    public void delete(long id);
    public List<User> findByName(String name);

}
