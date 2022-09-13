package com.example.demo.dao;

import com.example.demo.model.Course;
import com.example.demo.model.UserDetail;

import java.util.List;

public interface UserDetailDao {
    public List<UserDetail> getAll();

    public void save(UserDetail userDetail);

    public UserDetail get(int id);

    public void update(UserDetail userDetail);

    public void delete(int id);

    List<Course> getCourseByUserId(int id);
}