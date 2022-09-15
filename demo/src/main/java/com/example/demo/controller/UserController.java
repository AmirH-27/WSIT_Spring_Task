package com.example.demo.controller;

import com.example.demo.dto.CourseReq;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserRes;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDetail;
import com.example.demo.repo.CourseRepo;
import com.example.demo.repo.UserDetailRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserDetailRepo userDetailRepo;
    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/user/add")
    public User addUser(@RequestParam String name) {
        User user = new User(name);
        userRepo.save(user);
        return user;
    }
    @PostMapping("/user/add/detail")
    public UserDetail addUserDetail(@RequestParam String email, @RequestParam MultipartFile file, @RequestParam int userId) {
        UserDetail userDetail = new UserDetail(email, file.getOriginalFilename());
        User user = userRepo.findById(userId).orElse(null);
        userDetailRepo.save(userDetail);
        user.setUserDetail(userDetail);
        userRepo.save(user);
        return userDetail;
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    @PostMapping("/user")
    public User getUserById(@RequestParam int id) {
        return userRepo.findById(id).get();
    }
    @GetMapping("/user/course")
    public List<UserRes> getJoinInformation() {
        return userRepo.getJoinInformation();
    }
}
