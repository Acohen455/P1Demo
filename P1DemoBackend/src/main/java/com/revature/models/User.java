package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

//The model is just the representation of the data we pass between things
//This isnt a layer, this is just data representation
//In some languages, model and business layer are combined into a single layer
//Here we're seperating them out


@Component //1 of 4 stereotype annotations (make a class a bean)
@Entity //This makes the class a DB entity
@Table(name = "users") //This annotation lets us specify the name of the DB table
public class User {

    @Id //This annotation makes this field the PK in the DB table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This annotation makes the PK auto-increment
    private int userId;

    //We don't need to specify @Column UNLESS we want to define a name, or constraints

    @Column(nullable = false) //so now every User needs a username
    private String username;

    private String password;

    private String role = "user"; //we can set a default role this way

    //boilerplate-----------------------------------------------

    //right click -> generate -> choose the boilerplate you want

    public User() {
    }

    public User(int userId, String password, String role, String username) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
