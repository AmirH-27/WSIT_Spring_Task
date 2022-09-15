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
public class UserDetail {
    @Id
    @GeneratedValue
    private int user_details_id;
    private String email;
    private String image_path;

    public UserDetail(String email, String originalFilename) {
        this.email = email;
        this.image_path = originalFilename;
    }
}
