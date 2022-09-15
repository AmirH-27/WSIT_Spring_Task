package com.example.demo.repo;

import com.example.demo.dto.UserRes;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("Select new com.example.demo.dto.UserRes(u.name, c.course_name) FROM User u JOIN u.courses c")
    public List<UserRes> getJoinInformation();
}
