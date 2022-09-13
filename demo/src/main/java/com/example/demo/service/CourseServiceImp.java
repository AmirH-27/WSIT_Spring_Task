package com.example.demo.service;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CourseServiceImp implements CourseService{
    private final CourseDao courseDao;

    public CourseServiceImp(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }

    @Override
    public void save(Course course) {
        courseDao.save(course);
    }

    @Override
    public Course get(int id) {
        return courseDao.get(id);
    }

    @Override
    public void update(Course Course) {
        courseDao.update(Course);
    }

    @Override
    public void delete(int id) {
        courseDao.delete(id);
    }
}
