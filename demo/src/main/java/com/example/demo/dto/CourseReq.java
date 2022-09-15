package com.example.demo.dto;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseReq {
    private Course course;
}
