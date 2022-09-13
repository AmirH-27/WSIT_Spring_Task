package com.example.demo.service;

import com.example.demo.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAll();

    public void save(Course course);

    public Course get(int id);

    public void update(Course Course);

    public void delete(int id);
}
