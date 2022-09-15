package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public User(String name) {
        this.name = name;
    }

    @OneToOne
    private UserDetail userDetail;

    @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
    private List<Course> courses;
}
