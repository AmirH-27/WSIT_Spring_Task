package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue
    private int course_id;
    private String course_name;
    private String course_code;

    public Course(String course_name, String course_code) {
        this.course_name = course_name;
        this.course_code = course_code;
    }
}
