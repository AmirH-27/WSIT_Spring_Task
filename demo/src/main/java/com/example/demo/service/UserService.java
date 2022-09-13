package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public void save(User user);
    public User getUserById(int id);
    public void delete(int id);
    public void update(User user);
}
