package com.example.demo.controller;

import antlr.StringUtils;
import com.example.demo.model.User;
import com.example.demo.model.UserDetail;
import com.example.demo.service.UserDetailService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@RestController
public class UserDetailsController {
    private final UserDetailService userDetailsService;

    public UserDetailsController(UserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/user/add-details")
    public String addUser(@RequestParam("email") String email, @RequestParam("image") MultipartFile image) throws IOException {
        UserDetail userDetail = new UserDetail();
        userDetail.setEmail(email);
        userDetail.setImage_path(image.getName()+"_"+System.currentTimeMillis()+"."+image.getContentType());
        userDetailsService.save(userDetail);

        String fileName = image.getOriginalFilename()+"_"+System.currentTimeMillis();
        userDetail.setImage_path(fileName+"_"+System.currentTimeMillis()+"."+"png");
        String uploadDir = "user-photos/" + userDetail.getId();
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try(InputStream is = image.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(is, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Could not save image file: " + fileName, e);
        }

        return "User added";
    }
}
