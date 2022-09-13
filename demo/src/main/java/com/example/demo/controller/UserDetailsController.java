package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDetail;
import com.example.demo.service.UserDetailService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
public class UserDetailsController {
    private final UserDetailService userDetailsService;

    public UserDetailsController(UserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/user/add-details")
    public String addUser(@RequestParam("email") String email, @RequestParam("image") MultipartFile image) {
        UserDetail userDetail = new UserDetail();
        userDetail.setEmail(email);
        userDetail.setImage_path(image.getName()+"_"+System.currentTimeMillis()+"."+image.getContentType());
        userDetailsService.save(userDetail);
        return "User added";
    }
}
