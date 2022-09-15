package com.example.demo.repo;

import com.example.demo.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepo extends JpaRepository<UserDetail, Integer> {

}
