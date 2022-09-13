package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {
    public void uploadFile(MultipartFile multipartFile) throws IOException {
        File file = new File("C:\\Users\\User\\Desktop\\test\\" + multipartFile.getOriginalFilename());
    }
}
