package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//import javax.persistence.Table;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Blog> blogList = new ArrayList<>();//new ArrayList, taki default type null na ho
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.firstName = "test";
        this.lastName = "test";
    }
    public User(){//@Entity annotations rule -> all args is there so no args bhi compulsory h

    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}