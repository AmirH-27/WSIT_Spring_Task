package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.UserDetail;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserDetailService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    private final CourseService courseService;
    private final UserService userService;

    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }
    @RequestMapping("/course/add")
    public String addCourse(@RequestParam("name") String name, @RequestParam("code") String code, @RequestParam("userId")int id) {
        Course course = new Course();
        course.setCourseName(name);
        course.setCourseCode(code);
        userService.getUserById(id).getUserDetails().getCourses().add(course);
        course.setUserDetail(userService.getUserById(id).getUserDetails());
        courseService.save(course);
        return "Course added";
    }
}
