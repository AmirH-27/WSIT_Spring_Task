package com.example.demo.dao;

import com.example.demo.model.Course;
import com.example.demo.model.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CourseDaoImp implements CourseDao {
    private final SessionFactory sessionFactory;

    public CourseDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Course> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Course> query = session.createQuery("from Course", Course.class);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public void save(Course userDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(userDetail);
    }

    @Override
    public Course get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public void update(Course userDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userDetail);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Course userDetail = session.get(Course.class, id);
        session.delete(userDetail);
    }
}
