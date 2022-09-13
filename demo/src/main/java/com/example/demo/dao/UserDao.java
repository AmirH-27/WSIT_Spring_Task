package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();

    public void save(User user);

    public User get(int id);

    public void update(User user);

    public void delete(int id);
}
