package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRes {
    private String name;
    private String courseName;

    public UserRes(String name, String courseName) {
        this.name = name;
        this.courseName = courseName;
    }
}
