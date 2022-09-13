package com.example.demo.dao;

import com.example.demo.model.Course;

import java.util.List;

public interface CourseDao {
    public List<Course> getAll();

    public void save(Course userDetail);

    public Course get(int id);

    public void update(Course userDetail);

    public void delete(int id);
}
