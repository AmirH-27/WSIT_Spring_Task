package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetail userDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDetail getUserDetails() {
        return userDetail;
    }

    public void setUserDetails(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String toString() {
        return "User id: "+getId()+", User name: "+getName()+", User Email: "+getUserDetails().getEmail()+'\n';
    }
}
