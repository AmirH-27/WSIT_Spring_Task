package com.example.demo.service;

import com.example.demo.dao.UserDetailDao;
import com.example.demo.model.Course;
import com.example.demo.model.UserDetail;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserDetailServiceImp implements UserDetailService{
    private final UserDetailDao userDetailDao;

    public UserDetailServiceImp(UserDetailDao userDetailDao) {
        this.userDetailDao = userDetailDao;
    }

    @Override
    public List<UserDetail> getAll() {
        return userDetailDao.getAll();
    }

    @Override
    public void save(UserDetail userDetail) {
        userDetailDao.save(userDetail);
    }

    @Override
    public UserDetail get(int id) {
        return userDetailDao.get(id);
    }

    @Override
    public void update(UserDetail userDetail) {
        userDetailDao.update(userDetail);
    }

    @Override
    public void delete(int id) {
        userDetailDao.delete(id);
    }

    @Override
    public List<Course> getCourseByUserId(int id) {
        return userDetailDao.getCourseByUserId(id);
    }
}
