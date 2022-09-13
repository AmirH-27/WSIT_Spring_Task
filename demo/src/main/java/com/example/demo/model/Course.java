package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_code")
    private String courseCode;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_details_id")
    private UserDetail userDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public UserDetail getUserDetails() {
        return userDetail;
    }

    public void setUserDetails(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
    public String toString() {
        return "Course id: "+getId()+", Course name: "+getCourseName()+", Course Code: "+getCourseCode()+'\n';
    }
}
