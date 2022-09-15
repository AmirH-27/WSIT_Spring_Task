package com.example.demo.repo;

import com.example.demo.dto.UserDetailRes;
import com.example.demo.dto.UserRes;
import com.example.demo.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDetailRepo extends JpaRepository<UserDetail, Integer> {

}
