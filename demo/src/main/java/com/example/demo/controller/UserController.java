package com.example.demo.controller;
import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.model.UserDetail;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserDetailService;
import com.example.demo.service.UserDetailServiceImp;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private final UserDetailService userDetailService;
    private final CourseService courseService;

    public UserController(UserService userService, UserDetailService userDetailService , CourseService courseService) {
        this.userService = userService;
        this.userDetailService = userDetailService;
        this.courseService = courseService;
    }
    @RequestMapping("/list")
    public String list() {
        List<User> users = new ArrayList<>();
        users = userService.getUsers();
        return users.toString();
    }
    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        return userService.getUserById(id).toString();
    }
    @PostMapping("/user/add/{name}")
    public String addUser(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        userService.save(user);
        return "User added";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "User deleted";
    }

    @PostMapping("/user/update/{id}/{name}")
    public String updateUser(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        userService.update(user);
        return "User updated";
    }

    @RequestMapping("/user/course/{id}")
    public String courseList(@PathVariable int id) {
         return userService.getUserById(id).getUserDetails().getCourses().toString();
    }
}
