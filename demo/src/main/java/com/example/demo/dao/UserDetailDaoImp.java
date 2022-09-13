package com.example.demo.dao;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.model.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDetailDaoImp implements UserDetailDao{
    private final SessionFactory sessionFactory;

    public UserDetailDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserDetail> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<UserDetail>query = session.createQuery("from UserDetail", UserDetail.class);
        List<UserDetail> userDetailList = query.getResultList();
        return userDetailList == null ? new ArrayList<UserDetail>() : userDetailList;
    }

    @Override
    public void save(UserDetail userDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(userDetail);
    }

    @Override
    public UserDetail get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(UserDetail.class, id);
    }

    @Override
    public void update(UserDetail userDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userDetail);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserDetail userDetail = session.get(UserDetail.class, id);
        session.delete(userDetail);
    }

    @Override
    public List<Course> getCourseByUserId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserDetail userDetail = session.get(UserDetail.class, id);
        return userDetail.getCourses();
    }


}
