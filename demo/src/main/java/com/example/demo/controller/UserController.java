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

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    @PostMapping("user/update")
    public User updateUser(@RequestParam int id, @RequestParam String name) {
        User user = userRepo.findById(id).get();
        user.setName(name);
        userRepo.save(user);
        return user;
    }
    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam int id) {
        userRepo.deleteById(id);
        return "User deleted";
    }
    @PostMapping("/user/add/detail")
    public UserDetail addUserDetail(@RequestParam String email, @RequestParam MultipartFile file, @RequestParam int userId) throws IOException {
        UserDetail userDetail = new UserDetail(email, file.getOriginalFilename()+System.currentTimeMillis()+file.getContentType());
        User user = userRepo.findById(userId).orElse(null);
        userDetailRepo.save(userDetail);
        user.setUserDetail(userDetail);
        userRepo.save(user);

        String fileName = file.getOriginalFilename()+System.currentTimeMillis();
        userDetail.setImage_path(fileName+"_"+System.currentTimeMillis()+"."+file.getContentType());
        String uploadDir = "user-photos/" + userDetail.getUser_details_id();
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return userDetail;
    }

    @PostMapping("user/update/detail")
    public UserDetail updateUserDetail(@RequestParam int id, @RequestParam String email, @RequestParam MultipartFile file) {
        User user = userRepo.findById(id).orElse(null);
        UserDetail userDetail = userDetailRepo.findById(user.getUserDetail().getUser_details_id()).get();
        userDetail.setEmail(email);
        userDetail.setImage_path(file.getOriginalFilename()+System.currentTimeMillis()+file.getContentType());
        userDetailRepo.save(userDetail);
        return userDetail;
    }

    @PostMapping("/user/add/course")
    public Course addCourse(@RequestParam String courseName, @RequestParam String courseCode, @RequestParam int userId) {
        User user = userRepo.findById(userId).orElse(null);
        Course course = new Course(courseName, courseCode);
        courseRepo.save(course);
        user.getCourses().add(course);
        userRepo.save(user);
        return course;
    }

    @GetMapping("/user/list")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    @PostMapping("/user/detail")
    public UserDetail getUserById(@RequestParam int id) {
        User user = userRepo.findById(id).orElse(null);
        return userDetailRepo.findById(user.getUserDetail().getUser_details_id()).get();
    }
    @GetMapping("/user/course")
    public List<UserRes> getJoinInformation() {
        return userRepo.getJoinInformation();
    }
}
